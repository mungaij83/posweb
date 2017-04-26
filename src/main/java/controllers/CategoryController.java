package main.java.controllers;

import main.java.dao.CategoryDao;
import main.java.dao.SubCategoryDao;
import main.java.models.Category;
import main.java.models.SubCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@RequestMapping("/category")
public class CategoryController extends WebMvcConfigurerAdapter {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	SubCategoryDao scategoryDao;

	/**
	 * Category form
	 * 
	 * @return
	 */
	@GetMapping("/add")
	public String addCategory() {
		return "product/category-add";
	}

	/**
	 * Add category
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView addCategory(Category category) {
		ModelAndView model = new ModelAndView();
		try {
			Category c = categoryDao.save(category);
			if (c != null) {
				model.setViewName("redirect:/category/view");
			} else {
				model.setViewName("product/category-add");
				model.addObject("category", category);
			}
		} catch (Exception ex) {
			model.addObject("error",
					"Error processing request: " + ex.getMessage());
		}
		return model;
	}

	/**
	 * View All categories in database
	 * 
	 * @return
	 */
	@RequestMapping(path = "/view", method = RequestMethod.GET)
	public ModelAndView viewCategories() {
		ModelAndView model = new ModelAndView();
		Iterable<Category> categories = categoryDao.findAll();
		model.addObject("categories", categories);
		model.setViewName("product/categories");
		return model;
	}

	/**
	 * View All categories in database
	 * 
	 * @return
	 */
	@RequestMapping(path = "/view/{id}", method = RequestMethod.GET)
	public ModelAndView viewCategories(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView();
		Category category = categoryDao.findOne(id);
		model.addObject("category", category);
		model.setViewName("product/categories");
		return model;
	}

	/**
	 * Add sub-category to a category
	 * 
	 * @param id
	 *            Category ID to add to
	 */
	@RequestMapping(path = "/sub/{id}", method = RequestMethod.POST)
	public ModelAndView addSubCategory(@PathVariable("id") Long id) {
		Category category = categoryDao.findOne(id);
		ModelAndView model = new ModelAndView();
		if (category != null) {
			model.addObject("category", category);
		} else {
			model.addObject("error", "Category does not exist");
		}
		model.setViewName("product/sub-category-add");
		return model;
	}

	/**
	 * Add sub-category to a category
	 * 
	 * @param id
	 * @param scat
	 * @return
	 */
	@RequestMapping(path = "/add-sub/{id}", method = RequestMethod.POST)
	public ModelAndView addSubCategory(@PathVariable("id") Long id,
			@RequestBody SubCategory scat) {
		ModelAndView model = new ModelAndView();
		SubCategory s = scategoryDao.save(scat);

		if (s != null) {
			model.addObject("error", "Error adding sub-category");
			model.addObject("scategory", scat);
		} else {
			model.addObject("scategory", s);
		}

		return model;
	}
}
