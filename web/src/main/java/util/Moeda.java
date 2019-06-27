package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Renan Costa
 */
public class Moeda {

    public static BigDecimal valorComDesconto(BigDecimal valor,
                                              Double porcentagem) {
        if (porcentagem == null) {
            return valor;
        }
        Double porcentagemDesconto = (porcentagem / 100);
        BigDecimal desconto = new BigDecimal(BigInteger.ZERO);
        desconto = Moeda.multiplicarRetornaBigDecimal(valor,
                String.valueOf(porcentagemDesconto));
        return Moeda.subtrair(valor, desconto);
    }

    public static BigDecimal calculoTaxaServico(BigDecimal valor,
                                                Double porcentagem) {
        if (porcentagem > 100) {
            return new BigDecimal(BigInteger.ZERO);
        }
        Double porcentagemTaxa = (porcentagem / 100);
        return Moeda.multiplicarRetornaBigDecimal(valor,
                String.valueOf(porcentagemTaxa));
    }

    public static BigDecimal somar(BigDecimal valor1, BigDecimal valor2) {
        valor1 = valor1.add(valor2);
        return valor1.setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal subtrair(BigDecimal valor1, BigDecimal valor2) {
        valor1 = valor1.subtract(valor2);
        return valor1.setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal multiplicarRetornaBigDecimal(BigDecimal valor1,
                                                          String valor2) {
        BigDecimal bigDecimal = new BigDecimal(valor2);
        valor1 = valor1.multiply(bigDecimal);
        return valor1.setScale(2, RoundingMode.HALF_UP);
    }

    public static String multiplicarRetornaStringFormatada(BigDecimal valor1,
                                                           String valor2) {
        BigDecimal bigDecimal = new BigDecimal(valor2);
        // Efetua a multiplicacao
        valor1 = valor1.multiply(bigDecimal);
        return valueOf(valor1);
    }

    public static String multiplicarRetornaStringFormatada(String valor1,
                                                           String valor2) {
        BigDecimal bigDecimalValor1 = new BigDecimal(valor1);
        BigDecimal bigDecimal = new BigDecimal(valor2);
        // Efetua a multiplicacao
        bigDecimalValor1 = bigDecimalValor1.multiply(bigDecimal);
        return valueOf(bigDecimalValor1);
    }

    public static BigDecimal valueOf(String valor) {
        if (valor != null) {
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale(
                    "pt", "BR"));
            DecimalFormat df = new DecimalFormat("#,##0.00", dfs);
            try {
                BigDecimal bigDecimal = new BigDecimal(String.valueOf(df
                        .parse(valor)));
                return bigDecimal.setScale(2, RoundingMode.HALF_UP);
            } catch (ParseException ex) {
                Logger.getLogger(Moeda.class.getName()).log(Level.SEVERE, null,
                        ex);
                return null;
            }
        }
        return null;
    }

    public static String valueOf(BigDecimal valor) {
        if (valor != null) {
            // Formata o resultado da multiplicacao no padrao da moeda
            // brasileira 999.999.999,99
            NumberFormat format = DecimalFormat.getNumberInstance(new Locale(
                    "pt", "BR"));
            format.setMinimumFractionDigits(2);
            return format.format(valor.setScale(2, RoundingMode.HALF_UP));
        }
        return "";
    }

}
