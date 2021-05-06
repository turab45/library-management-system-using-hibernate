package dao;

import java.util.List;
import models.Category;

public interface CategoryDao {
	public Integer addCategory(Category category);
	public Integer updateCategory(Category category);
	public Integer deleteCategory(Category c);
	public Integer getIdByName(String name);
	public Category getCategoryById(Integer id);
	public List<Category> getAllCategory();
}
