package strings.desafio;

import java.util.List;

import org.apache.commons.validator.routines.IntegerValidator;

public class Runner {

	public static void main(String[] args) {
		if (!validateArgs(args)) {
			System.out.println("Usage: jar strings.desafio-0.0.1.jar numLimit justificadoFlg 'Lorem ipsum dolor sit amet...'");
			System.out.println(" - numLimit: Inteiro maior que zero. Diz a quantidade de caracteres permitidos por linha.");
			System.out.println(" - justificadoFlg: Boolean (true/false). Diz se o texto deve ser justificado.");
			System.out.println(" - 'Lorem ipsum dolor sit amet...': String. Texto a ser formatado.");
			System.exit(1);
		}

		TextFormatter textFormater = new TextFormatter();
		textFormater.setNumLimit(IntegerValidator.getInstance().validate(args[0]));
		textFormater.setJustify(new Boolean(args[1]));
		textFormater.setText(args[2]);

		List<String> result = textFormater.format();

		for (String line : result) {
			System.out.println(line);
		}
	}

	static boolean validateArgs(String[] args) {
		if (args == null || args.length < 3) {
			return false;
		}

		IntegerValidator intValidator = IntegerValidator.getInstance();
		if (!intValidator.isValid(args[0])) {
			return false;
		}

		if (intValidator.validate(args[0]) <= 0) {
			return false;
		}

		if (args[1].compareToIgnoreCase("true") != 0 && args[1].compareToIgnoreCase("false") != 0) {
			return false;
		}

		return true;
	}

}
