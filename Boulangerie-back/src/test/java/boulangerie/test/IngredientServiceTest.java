package boulangerie.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import boulangerie.config.AppConfig;
import boulangerie.exception.IngredientException;
import boulangerie.model.Basique;
import boulangerie.model.Categorie;
import boulangerie.model.Ingredient;
import boulangerie.model.LigneIngredient;
import boulangerie.service.BasiqueService;
import boulangerie.service.IngredientService;
import boulangerie.service.LigneIngredientService;

@Transactional
@Rollback
@SpringJUnitConfig(AppConfig.class)
class IngredientServiceTest {
	@Autowired
	IngredientService ingredientSrv;
	@Autowired
	LigneIngredientService lignesIngredientSrv;
	@Autowired
	BasiqueService basiqueSrv;

	
	@Test
	void testCreate() {
		Ingredient ingredient = new Ingredient("Chocolat", true);
		ingredientSrv.create(ingredient);
		assertNotNull(ingredientSrv.findById(ingredient.getId()));
		assertThrows(IngredientException.class, () -> {
			ingredientSrv.create(new Ingredient());
		});
	}

	@Test
	void testUpdate() {
		Ingredient ingredient = new Ingredient("Chocolat", true);
		ingredientSrv.create(ingredient);
		ingredientSrv.update(ingredient);
		ingredient = ingredientSrv.findById(ingredient.getId());
		
	}

	@Test
	void testFindAll() {
		assertTrue(ingredientSrv.findAll().isEmpty());
		Ingredient ingredient = new Ingredient("Chocolat", true);
		ingredientSrv.create(ingredient);

		assertEquals(1, ingredientSrv.findAll().size());

	}
	
	@Test
	void testFindByLignesingredientProduit() {
		assertTrue(ingredientSrv.findAll().isEmpty());
		Ingredient ingredient = new Ingredient("Chocolat", true);
		ingredientSrv.create(ingredient);
		
		LigneIngredient lignesIngredient = new LigneIngredient();
		BigDecimal prix = new BigDecimal("3.5");
		Basique basique = new Basique(prix, "Tarte", Categorie.Gateau);
		
		lignesIngredient.setProduit(basique);
		lignesIngredient.setIngredient(ingredient);
		basiqueSrv.create(basique);
		lignesIngredientSrv.create(lignesIngredient);
		
		ingredientSrv.findByLignesingredientProduit(basique);

		assertEquals(1, ingredientSrv.findAll().size());

	}

	@Test
	void testDeleteIngredient() {
		Ingredient ingredient = new Ingredient("Chocolat", true);
		ingredientSrv.create(ingredient);
		ingredientSrv.delete(ingredient);
		assertThrows(IngredientException.class, () -> {
			ingredientSrv.findById(ingredient.getId());
		});
	}

	@Test
	void testDeleteInteger() {
		Ingredient ingredient = new Ingredient("Chocolat", true);
		ingredientSrv.create(ingredient);
		ingredientSrv.delete(ingredient.getId());
		assertThrows(IngredientException.class, () -> {
			ingredientSrv.findById(ingredient.getId());
		});
	}

}
