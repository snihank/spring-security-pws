package com.company.ShakibKarimU1Capstone.dao;


import com.company.ShakibKarimU1Capstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxRateDaoJdbcImpl implements SalesTaxRateDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesTaxRateDaoJdbcImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String SELECT_SALESTAX_BY_STATE_SQL =
            "select * from sales_tax_rate where state = ?";

    @Override
    public SalesTaxRate getSalesTaxByState(String state){

        try {

            return jdbcTemplate.queryForObject(SELECT_SALESTAX_BY_STATE_SQL, this::mapRowToSalesTaxRate, state);

        }catch(
    EmptyResultDataAccessException e){
        return null;
    }

    }
//    @Override
//    public List<SalesTaxRate> getAllSalesTax(){
//        return jdbcTemplate.query(SELECT_ALL_SALESTAX_SQL, this::mapRowToSalesTaxRate);
//    }
//
//    @Override
//    public void deleteSalesTaxRate() {
//        jdbcTemplate.update(DELETE_ALL_SALESTAX_SQL);
//    }

    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate str = new SalesTaxRate();
        str.setState(rs.getString("state"));
        str.setRate(rs.getBigDecimal("rate"));
        return str;
    }
}
