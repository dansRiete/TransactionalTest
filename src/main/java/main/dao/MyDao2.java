package main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import javax.sql.DataSource;

/**
 * @author The Weather Company, An IBM Business
 */
@Repository
public class MyDao2 {
    private final static String INSERT_SQL = "INSERT INTO test2 (text, date_time) VALUES (:text, :date_time);";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public MyDao2(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void save(){
        final MapSqlParameterSource queryParams = new MapSqlParameterSource();
        queryParams.addValue("text", "Test string");
        queryParams.addValue("date_time", new Timestamp(System.currentTimeMillis()), Types.TIMESTAMP);
        namedParameterJdbcTemplate.update(INSERT_SQL, queryParams);
    }
}
