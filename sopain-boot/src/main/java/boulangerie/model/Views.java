package boulangerie.model;

public class Views {
	public static class ViewBase {
	}

	public static class ViewArticleFavoris extends ViewBase {
	}
	
	public static class ViewProduit extends ViewBase {
	}
	
	
	public static class ViewCommandeWithLignesIngredient extends ViewProduit {
	}
	
	public static class ViewIngredient extends ViewBase {
	}
	
	public static class ViewCommandeWithLignesCommande extends ViewIngredient {
	}
	
	
	public static class ViewLigneIngredient extends ViewBase {
	}
	
	public static class ViewCommande extends ViewBase {
	}
	
	public static class ViewIngredientWithLignesIngredient extends ViewCommande {
	}

	public static class ViewLigneCommande extends ViewBase {
	}
	
	public static class ViewCompte extends ViewBase {
	}
	
	public static class ViewEmploye extends ViewCompte {
	}
	
	public static class ViewClient extends ViewCompte {
	}
	
	public static class ViewClientWithCommandes extends ViewClient {
	}
	
	public static class ViewClientWithArticlesFavoris extends ViewClient {
	}
	
}
