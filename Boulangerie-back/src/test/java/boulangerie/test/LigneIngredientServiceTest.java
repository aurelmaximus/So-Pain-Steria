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
import boulangerie.exception.LigneIngredientException;
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
class LigneIngredientServiceTest {
	@Autowired
	IngredientService ingredientSrv;
	@Autowired
	LigneIngredientService lignesIngredientSrv;
	@Autowired
	BasiqueService basiqueSrv;

	
	@Test
	void testCreate() {
		LigneIngredient lignesIngredient = new LigneIngredient();
		lignesIngredientSrv.create(lignesIngredient);
		assertNotNull(ingredientSrv.findById(lignesIngredient.getId()));
		assertThrows(LigneIngredientException.class, () -> {
			lignesIngredientSrv.create(new LigneIngredient());
		});
	}

	@Test
	void testUpdate() {
		LigneIngredient lignesIngredient = new LigneIngredient();
		lignesIngredientSrv.create(lignesIngredient);
		lignesIngredientSrv.update(lignesIngredient);
		lignesIngredient = lignesIngredientSrv.findById(lignesIngredient.getId());
		
	}

	@Test
	void testFindAll() {
		assertTrue(lignesIngredientSrv.findAll().isEmpty());
		LigneIngredient lignesIngredient = new LigneIngredient();
		lignesIngredientSrv.create(lignesIngredient);

		assertEquals(1, lignesIngredientSrv.findAll().size());

	}
	
	
	@Test
	void testDeleteLigneingredient() {
		LigneIngredient lignesIngredient = new LigneIngredient();
		Ingredient ingredient = new Ingredient("Chocolat", true);
		ingredientSrv.create(ingredient);
		
		BigDecimal prix = new BigDecimal("3.5");
		Basique basique = new Basique(prix, "Tarte", Categorie.Gateau);
		basiqueSrv.create(basique);
		
		lignesIngredient.setIngredient(ingredient);
		lignesIngredient.setProduit(basique);
		lignesIngredientSrv.create(lignesIngredient);
		
		lignesIngredientSrv.delete(lignesIngredient);
		assertThrows(LigneIngredientException.class, () -> {
			ingredientSrv.findById(lignesIngredient.getId());
		});
	}

	@Test
	void testDeleteInteger() {
		LigneIngredient lignesIngredient = new LigneIngredient();
		Ingredient ingredient = new Ingredient("Chocolat", true);
		ingredientSrv.create(ingredient);
		
		BigDecimal prix = new BigDecimal("3.5");
		Basique basique = new Basique(prix, "Tarte", Categorie.Gateau);
		basiqueSrv.create(basique);
		
		lignesIngredient.setIngredient(ingredient);
		lignesIngredient.setProduit(basique);
		lignesIngredientSrv.create(lignesIngredient);
		
		lignesIngredientSrv.delete(lignesIngredient.getId());
		assertThrows(LigneIngredientException.class, () -> {
			lignesIngredientSrv.findById(lignesIngredient.getId());
		});
	}

}
