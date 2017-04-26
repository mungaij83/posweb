package main.java.dao;

import main.java.models.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CategoryDao extends CrudRepository<Category, Long>{
	/**
	@Modifying
    @Query("update categories t SET t.name=:name, t.description=:desc WHERE t.categoryId=:id")
    public void update(@Param("id") Long id, @Param("name") String title,@Param("desc") String description);
    */
}
