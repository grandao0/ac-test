package com.cassio.actest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cassio.actest.model.Product;

@Repository
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select new map(p.id as id, p.name as name, p.description as description) from Product p order by p.name")
	public List<Product> findExcluding();

	@Query("select new map(p.id as id, p.name as name, p.description as description) from Product p where p.id=?1 order by p.name")
	public List<Product> findExcludingById(Long id);

	public List<Product> findByParentId(Long id);
}