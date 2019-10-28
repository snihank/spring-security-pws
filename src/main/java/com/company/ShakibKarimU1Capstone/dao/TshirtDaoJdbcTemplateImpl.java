package com.company.ShakibKarimU1Capstone.dao;


import com.company.ShakibKarimU1Capstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TshirtDaoJdbcTemplateImpl implements TshirtDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public TshirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_TSHIRT_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String SELECT_TSHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_TSHIRTS_SQL =
            "select * from t_shirt";

    private static final String UPDATE_TSHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private static final String DELETE_TSHIRT =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String SELECT_TSHIRT_BY_COLOR =
            "select * from t_shirt where color = ?";

    private static final String SELECT_TSHIRT_BY_SIZE =
            "select * from t_shirt where size = ?";

    private TShirt mapTShirtToRow(ResultSet rs, int rowNum) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(rs.getInt("t_shirt_id"));
        tShirt.setSize(rs.getString("size"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));

        return tShirt;
    }

    @Override
    public TShirt createTshirt(TShirt tshirt) {
        jdbcTemplate.update(INSERT_TSHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        tshirt.settShirtId(id);

        return tshirt;
    }

    @Override
    public TShirt getTshirt(int tShirtId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TSHIRT_SQL, this::mapTShirtToRow, tShirtId);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<TShirt> getAllTshirts() {
        return jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapTShirtToRow);
    }

    @Override
    public void updateTshirt(TShirt tshirt) {

        jdbcTemplate.update(UPDATE_TSHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity(),
                tshirt.gettShirtId());
    }

    @Override
    public void deleteTshirt(int tShirtId) {
        jdbcTemplate.update(DELETE_TSHIRT, tShirtId);
    }

    @Override
    public List<TShirt> getTshirtByColor(String color) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_COLOR, this::mapTShirtToRow, color);
    }

    @Override
    public List<TShirt> getTshirtBySize(String size) {
        return jdbcTemplate.query(SELECT_TSHIRT_BY_SIZE, this::mapTShirtToRow, size);
    }


}
