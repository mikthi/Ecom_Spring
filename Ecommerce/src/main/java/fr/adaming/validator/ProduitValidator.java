package fr.adaming.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.adaming.model.Produit;

@Component
public class ProduitValidator implements Validator{

	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class Prod) {
		return Produit.class.isAssignableFrom(Prod);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom",
				"Le renseignement de ce champ est indispensable.",
				"Le renseignement du nom du produit est indispensable.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"Le renseignement de ce champ est indispensable.",
				"Le renseignement de la description du produit est indispensable.");
		
	}

}
