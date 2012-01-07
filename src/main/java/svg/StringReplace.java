/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package svg;

/**
 *
 * @author wb385924
 */
public class StringReplace {

    public static void main(String[] args){
//        String x = "M 57.57 20.51 l -0.27 -0.08 0.32 -0.45 0.17 0.28 z M 50.5 15.35 l -0.25 0.54 -0.27 -0.13 -0.13 -0.27 -0.21 0.22 0.17 0.88 -0.38 0.81 -0.07 0.89 -2.19 6.53 -0.2 0.23 -1.7 0.54 -1.09 -0.49 -0.49 -0.75 -0 -0.89 -0.4 -0.81 -0.04 -0.6 1.21 -2.17 -0.5 -2.32 0.55 -1.37 1.74 -0.35 0.39 -0.46 1 -0.6 0.22 -0.21 0.18 -0.87 0.75 -0.45 0.12 -0.88 0.24 -0.18 0.29 0.08 0.5 0.77 0.32 1.76 z M 44.49 12.09 l 0.03 0.29 -0.3 -0.22 z M 43.46 11.93 l -0.24 -0.17 0.07 -0.39 0.11 0.03 z M 39.44 6.19 l 0.09 -0 -0.01 0.28 -0.31 -0.24 0.11 -0.5 z M 55.54 4.76 l -0.16 -0.14 0.07 -0.07 z M 6.56 -0.03 l -0.09 -0.23 0.22 -0.14 0.06 0.18 z M 8.86 -3.5 l -0.16 0.3 -0.25 -0.07 0.24 -0.47 0.27 0.04 z M -23.45 -14.98 l -0.23 0.04 -0.09 -0.32 z M -24.03 -16.59 l -0.29 0.11 -0.11 -0.17 z M -25.21 -16.92 l -0.15 -0.16 0.32 -0.1 0.06 0.09 z M -6.66 -26.13 l 7.54 4.84 0.24 0.18 0.07 0.29 0.7 0.56 1.13 0.34 0.25 0.53 -0.16 0.25 0.24 0.17 2.45 -0.47 1.65 -1.41 4.52 -2.67 1.56 0.35 0.69 0.55 1.77 -0.84 8 3.95 0 -0.5 0.99 -0 0 -2 5.94 0.04 0.26 -0.14 0.28 0.1 5.4 -0 -0 0.3 0.31 0.51 0.01 1.19 0.25 1.17 1.15 0.84 0.4 0.8 0.51 1.71 0.19 0.23 0.25 -0.16 0.37 0.45 0.81 0.36 1.98 1.9 -0.42 0.27 -0.3 -0.03 -0.58 0.8 -0.04 0.6 1.17 0.07 0.31 -0.47 0.82 0.86 0.54 0.19 1.12 -0.4 0.89 0.08 0.79 -0.43 1.76 -0.12 1.15 -0.33 0.47 -0.36 0.29 0.08 0.19 0.23 -0.16 0.25 0.03 0.9 -0.29 0.52 -0.18 0.87 -1.4 2.3 -0.46 1.1 -0.84 1.24 -1.85 1.96 -1.52 0.95 -1.14 0.97 -1.22 1.33 -0.86 1.19 -0.29 0.09 -0.36 0.48 -0.52 0.29 -0.53 1.4 -0.46 0.51 -0.38 1.44 0.09 0.29 0.63 0.64 -0.27 0.53 0.14 0.27 -0.11 0.58 0.6 1.67 0.69 0.65 -0.2 0.55 0.18 2.97 0.21 0.22 0.03 0.3 -0.18 0.57 -0.92 1.18 -0.74 0.51 -1.13 0.39 -1.03 0.59 0.02 0.3 -0.97 0.68 -0.63 0.64 -0.54 0.26 0.06 0.6 0.3 0.52 0.45 1.41 -0.06 1.78 -0.4 0.44 -2.19 0.95 -0.18 0.24 0.24 0.53 -0.04 0.5 -0.52 1.71 -1.14 0.96 -1.18 1.73 -1.58 1.37 -1.24 0.84 -0.84 0.31 -0.6 -0.02 -0.19 0.23 -0.86 0.19 -0.88 -0.15 -1.48 0.03 -0.52 0.29 -1.19 0.12 -0.83 0.33 -1.32 -0.68 -0.14 -0.24 -0.02 -0.3 -0.34 -0.51 -0.02 -0.26 0.36 -0.47 -0.15 -0.58 -0.83 -1.25 -0.89 -1.92 -0.72 -0.53 -0.47 -0.77 -0.36 -1.14 -0.11 -1.19 -0.34 -0.83 -0.04 -1.72 -1 -1.49 -0.33 -0.83 -0.58 -1.05 -0.57 -0.69 -0.22 -0.55 0.05 -2.03 0.21 -0.14 0.56 -2.16 1.21 -1.52 0.07 -0.99 -0.79 -1.83 0.31 -0.38 -0.05 -0.49 -0.56 -1.39 -0.41 -0.63 0.15 -0.2 0.7 -0.18 -0.71 0.13 -0.25 -0.22 -0.06 -0.5 -0.38 -0.68 -1.86 -1.91 -1.03 -1.63 -0.05 -0.24 0.39 -0.31 0.29 -0.66 -0.01 -0.5 0.3 -0.33 -0.4 -0.29 0.39 -0.64 0.17 -1.14 -0.36 -0.65 0.02 -0.25 -0.5 -0.03 -0.54 -0.82 -0.24 0.06 -0.14 0.21 -0.5 0.04 -0.2 -0.15 -0.72 0.1 -0.43 0.23 -0.49 -0.07 -0.34 -0.36 -0.18 -0.72 -0.68 -0.73 -1.18 -0.35 -0.46 0.19 -1.74 0.22 -0.55 0.36 -0.28 -0.03 -2.47 1.03 -1.16 -0.4 -0.5 0.03 -0.47 -0.16 -1.15 0.13 -2.24 0.84 -0.25 -0.03 -1.34 -0.65 -1.11 -1 -0.45 -0.2 -1.03 -0.83 -0.69 -0.29 -0.79 -1.05 -0.11 -0.83 -0.41 -0.65 -0.7 -0.36 -0.26 -0.3 0.03 -0.2 -0.48 -0.4 -0.2 0 -0.2 -0.75 -0.58 -0.02 -0.26 -0.29 -0.36 -0.13 -0.1 -0.93 0.25 -0.34 -0.41 -0.8 -0.42 -0.41 0.34 -0.21 0.46 -0.66 0.57 -2.41 -0.4 -1.43 0.16 -0.25 -0 -0.59 -0.57 -0.66 -0.22 0.24 0.1 -0.57 3.95 -0 -0.11 -1.56 0.53 -0.4 0.57 -0.16 -0 -2.55 3.33 -0 0 -1.29 z";


        String x = "M57.57|20.51|l|-0.27|-0.08|0.32|-0.45|0.17|0.28z | M50.5|15.35|l|-0.25|0.54|-0.27|-0.13|-0.13|-0.27|-0.21|0.22|0.17|0.88|-0.38|0.81|-0.07|0.89|-2.19|6.53|-0.2|0.23|-1.7|0.54|-1.09|-0.49|-0.49|-0.75|-0|-0.89|-0.4|-0.81|-0.04|-0.6|1.21|-2.17|-0.5|-2.32|0.55|-1.37|1.74|-0.35|0.39|-0.46|1|-0.6|0.22|-0.21|0.18|-0.87|0.75|-0.45|0.12|-0.88|0.24|-0.18|0.29|0.08|0.5|0.77|0.32|1.76z | M44.49|12.09|l|0.03|0.29|-0.3|-0.22z | M43.46|11.93|l|-0.24|-0.17|0.07|-0.39|0.11|0.03z | M39.44|6.19|l|0.09|-0|-0.01|0.28|-0.31|-0.24|0.11|-0.5z | M55.54|4.76|l|-0.16|-0.14|0.07|-0.07z | M6.56|-0.03|l|-0.09|-0.23|0.22|-0.14|0.06|0.18z | M8.86|-3.5|l|-0.16|0.3|-0.25|-0.07|0.24|-0.47|0.27|0.04z | M-23.45|-14.98|l|-0.23|0.04|-0.09|-0.32z | M-24.03|-16.59|l|-0.29|0.11|-0.11|-0.17z | M-25.21|-16.92|l|-0.15|-0.16|0.32|-0.1|0.06|0.09z | M-6.66|-26.13|l|7.54|4.84|0.24|0.18|0.07|0.29|0.7|0.56|1.13|0.34|0.25|0.53|-0.16|0.25|0.24|0.17|2.45|-0.47|1.65|-1.41|4.52|-2.67|1.56|0.35|0.69|0.55|1.77|-0.84|8|3.95|0|-0.5|0.99|-0|0|-2|5.94|0.04|0.26|-0.14|0.28|0.1|5.4|-0|-0|0.3|0.31|0.51|0.01|1.19|0.25|1.17|1.15|0.84|0.4|0.8|0.51|1.71|0.19|0.23|0.25|-0.16|0.37|0.45|0.81|0.36|1.98|1.9|-0.42|0.27|-0.3|-0.03|-0.58|0.8|-0.04|0.6|1.17|0.07|0.31|-0.47|0.82|0.86|0.54|0.19|1.12|-0.4|0.89|0.08|0.79|-0.43|1.76|-0.12|1.15|-0.33|0.47|-0.36|0.29|0.08|0.19|0.23|-0.16|0.25|0.03|0.9|-0.29|0.52|-0.18|0.87|-1.4|2.3|-0.46|1.1|-0.84|1.24|-1.85|1.96|-1.52|0.95|-1.14|0.97|-1.22|1.33|-0.86|1.19|-0.29|0.09|-0.36|0.48|-0.52|0.29|-0.53|1.4|-0.46|0.51|-0.38|1.44|0.09|0.29|0.63|0.64|-0.27|0.53|0.14|0.27|-0.11|0.58|0.6|1.67|0.69|0.65|-0.2|0.55|0.18|2.97|0.21|0.22|0.03|0.3|-0.18|0.57|-0.92|1.18|-0.74|0.51|-1.13|0.39|-1.03|0.59|0.02|0.3|-0.97|0.68|-0.63|0.64|-0.54|0.26|0.06|0.6|0.3|0.52|0.45|1.41|-0.06|1.78|-0.4|0.44|-2.19|0.95|-0.18|0.24|0.24|0.53|-0.04|0.5|-0.52|1.71|-1.14|0.96|-1.18|1.73|-1.58|1.37|-1.24|0.84|-0.84|0.31|-0.6|-0.02|-0.19|0.23|-0.86|0.19|-0.88|-0.15|-1.48|0.03|-0.52|0.29|-1.19|0.12|-0.83|0.33|-1.32|-0.68|-0.14|-0.24|-0.02|-0.3|-0.34|-0.51|-0.02|-0.26|0.36|-0.47|-0.15|-0.58|-0.83|-1.25|-0.89|-1.92|-0.72|-0.53|-0.47|-0.77|-0.36|-1.14|-0.11|-1.19|-0.34|-0.83|-0.04|-1.72|-1|-1.49|-0.33|-0.83|-0.58|-1.05|-0.57|-0.69|-0.22|-0.55|0.05|-2.03|0.21|-0.14|0.56|-2.16|1.21|-1.52|0.07|-0.99|-0.79|-1.83|0.31|-0.38|-0.05|-0.49|-0.56|-1.39|-0.41|-0.63|0.15|-0.2|0.7|-0.18|-0.71|0.13|-0.25|-0.22|-0.06|-0.5|-0.38|-0.68|-1.86|-1.91|-1.03|-1.63|-0.05|-0.24|0.39|-0.31|0.29|-0.66|-0.01|-0.5|0.3|-0.33|-0.4|-0.29|0.39|-0.64|0.17|-1.14|-0.36|-0.65|0.02|-0.25|-0.5|-0.03|-0.54|-0.82|-0.24|0.06|-0.14|0.21|-0.5|0.04|-0.2|-0.15|-0.72|0.1|-0.43|0.23|-0.49|-0.07|-0.34|-0.36|-0.18|-0.72|-0.68|-0.73|-1.18|-0.35|-0.46|0.19|-1.74|0.22|-0.55|0.36|-0.28|-0.03|-2.47|1.03|-1.16|-0.4|-0.5|0.03|-0.47|-0.16|-1.15|0.13|-2.24|0.84|-0.25|-0.03|-1.34|-0.65|-1.11|-1|-0.45|-0.2|-1.03|-0.83|-0.69|-0.29|-0.79|-1.05|-0.11|-0.83|-0.41|-0.65|-0.7|-0.36|-0.26|-0.3|0.03|-0.2|-0.48|-0.4|-0.2|0|-0.2|-0.75|-0.58|-0.02|-0.26|-0.29|-0.36|-0.13|-0.1|-0.93|0.25|-0.34|-0.41|-0.8|-0.42|-0.41|0.34|-0.21|0.46|-0.66|0.57|-2.41|-0.4|-1.43|0.16|-0.25|-0|-0.59|-0.57|-0.66|-0.22|0.24|0.1|-0.57|3.95|-0|-0.11|-1.56|0.53|-0.4|0.57|-0.16|-0|-2.55|3.33|-0|0|-1.29z";
        String y = x.replace("|l|", "l");
        System.out.println(y);
    }

}