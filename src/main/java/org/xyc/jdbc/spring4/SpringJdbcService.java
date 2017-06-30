package org.xyc.jdbc.spring4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by wks on date: 2017/6/30
 */
@Service
public class SpringJdbcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save() {
        int i = jdbcTemplate.update("insert into test(name, age, address) values(?,?,?)", "friday", 30, "ditiezhan");
        System.out.println("affected rows :" + i);
        return i;
    }

    public int batchSave() {
        String sql = "insert into test(name, age, address) values(?,?,?)";
        List<Object[]> list = Lists.newArrayList();
        list.add(new Object[]{"monday", 1, "shaghai"});
        list.add(new Object[]{"tuesday", 2, "newyork"});
        list.add(new Object[]{"wednesday", 3, "london"});
        int[] i = jdbcTemplate.batchUpdate(sql, list);
        System.out.println("affected rows :" + i);
        return i[0];
    }

    public int update() {
        String sql = "update test set name=?, age=?, address=? where id=?";
        int i = jdbcTemplate.update(sql, "thurday", 4, "dibai", 30);
        System.out.println("affected rows :" + i);
        return i;
    }

    public int delete() {
        String sql = "delete from test where id=?";
        int i = jdbcTemplate.update(sql, 30);
        System.out.println("affected rows :" + i);
        return i;
    }

    public List<Map<String, Object>> getAllGondria() {
        String sql = "select * from test";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql );
        System.out.println(list);
        return list;
    }

    public GondriaModel getGondriaById() {
        String sql = "select * from test where id=?";
        GondriaModel gondria = jdbcTemplate.queryForObject(sql, new Object[] { 28 }, new RowMapper<GondriaModel>() {
            @Override
            public GondriaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                GondriaModel gondria = new GondriaModel();
                gondria.setId(rs.getInt(1));
                gondria.setName(rs.getString(2));
                gondria.setAge(rs.getInt(3));
                gondria.setAddress(rs.getString(4));
                return gondria;
            }
        });
        System.out.println(gondria);
        return gondria;
    }

    @Transactional
    public void insertTwoGondria() {
        jdbcTemplate.update("insert into test(name, age, address) values(?,?,?)", "first", 15, "monsike");
        int i = 10 / 0;
        jdbcTemplate.update("insert into test(name, age, address) values(?,?,?)", "second", 35, "sibada");
        System.out.println();
    }
}
