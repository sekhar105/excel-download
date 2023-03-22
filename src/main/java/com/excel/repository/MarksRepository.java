package com.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excel.entity.Marks;
@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer>{

}
