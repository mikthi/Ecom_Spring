package fr.adaming.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.adaming.model.Categorie;

@Component
public class CategorieValidator implements Validator {

	/**
	 * V�rifier si la classe qu'on a entr�e est du bon type
	 */
	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class Categ) {
		return Categorie.class.isAssignableFrom(Categ);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom",
				"Le renseignement de ce champ est indispensable.",
				"Le renseignement du nom de la cat�gorie est indispensable.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"Le renseignement de ce champ est indispensable.",
				"Le renseignement de la description de la cat�gorie est indispensable.");

	}

}