package com.company.ShakibKarimU1Capstone.dao;

import com.company.ShakibKarimU1Capstone.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcImpl implements ProcessingFeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoJdbcImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String SELECT_PFEE_BY_ITEM_SQL =
            "select * from processing_fee where product_type = ?";


    @Override
    public ProcessingFee getFee(String item) {
        try {

            return jdbcTemplate.queryForObject(SELECT_PFEE_BY_ITEM_SQL, this::mapRowToProcessingFee, item);
        }catch(EmptyResultDataAccessException e){
            return null;
        }


    }

    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee fee = new ProcessingFee();
        fee.setProductType(rs.getString("product_type"));
        fee.setFee(rs.getBigDecimal("fee"));
        return fee;
    }


}
