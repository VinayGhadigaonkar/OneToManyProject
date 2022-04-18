package com.example.demo.repository;
 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
import com.example.demo.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>
{ 
	 public default Page<Product> finds(int pageNos,int pageSize)
	    {
			Pageable pageable = PageRequest.of(pageNos-1, pageSize);
			return this.findAll(pageable);
		}
}