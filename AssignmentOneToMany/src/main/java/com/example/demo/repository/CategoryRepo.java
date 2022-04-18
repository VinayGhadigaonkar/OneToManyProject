package com.example.demo.repository;

 
  
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
  
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>
	{	
	        public default Page<Category> findPaginated(int pageNo,int pageSize){
			Pageable pageable = PageRequest.of(pageNo-1, pageSize);
			return this.findAll(pageable);
		}
		
	}
