package com.hostBooks.CRUDUsingCriteriaQueryApp.dao;

import com.hostBooks.CRUDUsingCriteriaQueryApp.entity.EmployeeBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @PersistenceContext
    EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Override
    public EmployeeBO addEmployee(EmployeeBO employeeBO) {
        entityManager.persist(employeeBO);
        logger.info("Employee has added successfully, employee details=" + employeeBO);
        return employeeBO;
    }

    @Override
    public EmployeeBO updateEmployee(EmployeeBO employeeBO) {
        entityManager.merge(employeeBO);
        logger.info("Employee has updated successfully, Employee details=" + employeeBO);
        return employeeBO;
    }

    @Override
    public List<EmployeeBO> getEmployeeList() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeBO> criteriaQuery = criteriaBuilder.createQuery(EmployeeBO.class);
        Root<EmployeeBO> root = criteriaQuery.from(EmployeeBO.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("deleteFlag"), false));
       return entityManager.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public EmployeeBO getById(Integer id) {

        CriteriaBuilder criteriaBuilder =entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeBO> criteriaQuery =criteriaBuilder.createQuery(EmployeeBO.class);


        Root<EmployeeBO> root = criteriaQuery.from(EmployeeBO.class);
        Predicate predicateForId = criteriaBuilder.equal(root.get("empId"), id);
        Predicate predicateForDeleteFlag = criteriaBuilder.equal(root.get("deleteFlag"), false);
        Predicate predicate = criteriaBuilder.and(predicateForId,predicateForDeleteFlag);
        criteriaQuery.where(predicate);
        try {
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (EmptyResultDataAccessException | NoResultException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void delete(List<Integer> id) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<EmployeeBO> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(EmployeeBO.class);
        Root<EmployeeBO> root = criteriaUpdate.from(EmployeeBO.class);
        criteriaUpdate.where(root.get("empId").in(id));
        criteriaUpdate.set("deleteFlag", true);
        entityManager.createQuery(criteriaUpdate).executeUpdate();

        //criteria delete

    }
}
