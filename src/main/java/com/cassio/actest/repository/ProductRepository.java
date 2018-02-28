package com.cassio.actest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cassio.actest.model.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select p.id, p.name, p.description from Product p order by p.name")
	public List<Product> findExcluding();

	@Query("select p.id, p.name, p.description from Product p where p.id=?1 order by p.name")
	public List<Product> findExcludingById(Long id);

	@Query("select p.id, p.name, p.description from Product p where p.id=?1 order by p.name")
	public List<Product> findChildsById(Long id);
}