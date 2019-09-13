package com.tts.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class ActorDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    private static ActorDAO instance;

    private ActorDAO() {}

    public static ActorDAO getInstance() {
        if (instance == null) {
            instance = new ActorDAO();
        }
        return instance;
    }

    public List<Actor> findAll() {
        List<Actor> actors = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            String query = "select * from actor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                actors.add(new Actor(resultSet.getInt("actor_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return actors;
    }

    public Optional<Actor> findById(int id) {
        Actor result = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String query = "select * from actor where actor_id=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                result = new Actor(resultSet.getInt("actor_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"));
            }
            resultSet.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(result);
    }

    public Actor save(Actor actor) {
        String sql = "insert into actor(first_name, last_name, last_update) values(?,?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, actor.getFirstName());
            pst.setString(2, actor.getLastName());
            pst.setDate(3, new Date(Calendar.getInstance().getTime().getTime()));
            int uc = pst.executeUpdate();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                actor.setActorId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actor;
    }

    public void delete(Actor actor) {
        String sql = "delete from actor where actor_id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, actor.getActorId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
