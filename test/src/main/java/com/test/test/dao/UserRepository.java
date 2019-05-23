package com.test.test.dao;

import com.test.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findById(int id);

    public User findByName(String name);

    public List<User> findAll();

    @Query("from User where name=?1 and password=?2")
    public User userConfig(String name,String password);

    @Modifying
    @Transactional
    @Query(value="insert into User(name,password,mail) values(?1,?2,?3)",nativeQuery = true)
    public int addUser(String name,String password,String mail);
}
