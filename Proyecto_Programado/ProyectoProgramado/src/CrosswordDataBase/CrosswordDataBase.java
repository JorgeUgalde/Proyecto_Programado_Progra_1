
package CrosswordDataBase;

/**
 * This class has all the information of the crosswords 
 * @authors Jorge Ugalde, Moises Sánchez, Marlon Zúñiga
 * @version  11/07/2021
 */
public class CrosswordDataBase {

    /**
     * This method creates a vector with the different easy crosswords
     * information
     * @return It returns the information of the vector
     **/
    private String[] getEasyCrosswords() {
        return new String[]{
            """
            7-9
            0-2/1/V/DULCE/Sinonimo de confite
            1-5/2/V/HOLA/Saludo mas comun
            2-0/3/V/SUSTO/Impresión momentánea de miedo causada por algo inespeado
            2-0/3/H/SALADO/Lo contrario de dulce
            4-4/4/H/PASTA/Para lavarse los dientes""",
            """
            7-10
            0-5/1/V/NIEVE/Se hace presente en invierno
            1-3/2/H/FRIO/Contrario a caliente
            2-2/3/V/CLIMA/Caliente, frio, lluvioso...
            2-7/4/H/PIE/Parte del cuerpo con la que caminamos
            2-7/4/V/PAIS/Territorio especifico del planeta
            3-2/5/H/LLUVIA/Cae del cielo
            6-0/6/H/PLAYA/Lugar tipico de paseo""",
            """
            8-9
            0-0/1/V/GUIA/Sinonimo de maestro
            0-4/2/V/MAPA/Brinda guia de un lugar
            0-4/2/H/MAR/Conocido como oceano
            1-2/3/V/TIERRA/Donde vivimos
            3-0/4/H/ARENA/Presente en la playa
            4-6/5/V/ROCA/Objeto comunmente gris y duro
            5-1/6/H/FRESCO/Bebida tipica que acompaña las comidas
            5-4/7/V/SOL/Estrella que se hace presente en el dia 
            7-5/8/H/MALA/Femenino de malo"""
        };
    }

    /**
     * This method creates a vector with the different medium crosswords
     * information
     * @return It returns the information of the vector
     **/
    private String[] getMediumCrosswords() {
        return new String[]{
            """
            14-11
            0-9/1/V/DIA/Una semana comprende de 7
            1-7/2/V/SEGUNDO/Despues del primero
            2-6/3/H/META/Sueño,anhelo,objetivo
            3-1/4/V/FINAL/Indica que algo termino
            3-4/5/V/DIFICL/Presenta una gran dificultad
            4-0/6/H/BIBLIA/Libro principal de los cristianos
            4-9/7/V/ORDEN/La ley y el..
            7-4/8/H/COLORES/El arcoires tiene diferentes
            9-2/9/V/PANAL/Donde viven las abejas
            9-2/9/H/PALABRAS/Un crucigrama esta hecho de ellas""",
            """
            13-13
            0-11/1/V/CAMISA/Prenda de vestir para la parte superior del cuerpo
            1-4/2/V/DADO/Casualmente tiene 6 caras
            1-6/3/V/HURACAN/Producen vientos fuertes que pueden superar los 155 millas por hora
            1-8/4/H/CENA/Comida de la noche
            3-4/5/H/DORMIR/Acto que normalmente se hace en la noche
            4-0/6/H/SISMO/Tambien se le conoce como temblor
            5-6/7/H/CELULAR/Aparato electronico portatil, se pueden hacer llamadas o mensajes
            5-12/8/V/RICO/Que tiene mucho dinero
            7-3/9/H/PLANETA/Marte es un..
            7-8/10/V/TRISTE/Antonimo de feliz
            10-3/11/H/SIMIOS/Comunmente llamados monos
            12-5/12/H/CAFE/Bebida que tiene cafeina""",
            """
            13-13
            0-3/1/V/DOLAR/Moneda oficial de Estados Unidos
            0-6/2/V/MANZANA/Fruto prohibido
            1-2/3/H/COLLAR/Joya que se usa en el cuello
            2-1/4/V/PINTOR/Realiza pinturas
            3-0/5/H/VIDA/Antonimo de muerte
            4-8/6/V/PERRO/Animal domestico mas comun 
            5-4/7/V/LLAVES/Se utilizan para abrir puertas
            6-0/8/H/BOTELLA/Normalmente contienen liquidos
            7-10/9/V/HOGAR/Sinonimo de casa,vivienda
            8-7/10/H/FOTO/Para guardar recuerdos
            8-7/10/V/FAJA/Ajusta los pantalones
            9-3/11/H/MEDIA/Sinonimo de calcetin
            9-12/12/V/JAZZ/Genero musical en el que su instrumento musical principal es el saxofón
            10-9/13/H/CAMA/Donde normalmente se duerme"""
        };
    }

    /**
     * This method creates a vector with the different hard crosswords
     * information
     * @return It returns the information of the vector
     **/
    private String[] getHardCrosswords() {
        return new String[]{
            """
            17-13
            0-4/1/V/ESPADA/Utilizada por los caballeros
            1-0/2/H/JESUS/Personaje principal de la biblia
            2-10/3/V/ENCHUFE/Sirve para conectar algo y darle energia
            3-1/4/H/ALCANCIA/Sirve para ahorrar
            3-6/5/V/CHANCLETA/Forma popular como se le conoce a las sandalias
            4-0/6/V/SALCHICHA/Embutido que contienen los perros calientes 
            5-2/7/H/TRABAJO/Acto que es remunerado
            8-2/8/V/BOMBILLO/Genera luz
            8-4/9/H/BILLETERA/Sirve para guardar y transportar dinero
            10-0/10/H/COMPLETAR/Finalizar algo
            10-8/11/V/RUPTURA/Terminar una relación
            10-10/12/V/DEDOS/Una mano esta compuesta normalmente de 5
            13-6/13/H/FUTBOL/Deporte mas conocido
            15-1/14/H/CORRER/Accion parecida a caminar
            16-7/15/H/HACHA/Se utiliza para talar""",
            """
            16-17
            0-1/1/V/DERECHA/Lado por donde se maneja en Costa Rica
            1-9/2/V/FUMAR/Produce daños en los pulmones
            2-0/3/H/ARRIBA/Lado superior
            2-7/4/V/TRILOGIA/Consta de 3 partes
            4-4/5/H/SIMILAR/Sinonimo de parecido
            4-12/6/V/PISTA/Esta leyendo una 
            6-1/7/H/ARMARIO/Para guardar ropa
            7-10/8/V/MAYOR/Se representa con >
            8-3/9/V/CARGADOR/Funciona para cargar
            8-3/9/H/CRUCIGRAMA/Nombre de este juego
            10-5/10/V/ADIDAS/Rival de Nike
            10-9/11/H/NORTE/La brujula marca hacia ese punto
            10-13/12/V/ESPEJO/Se puede ver el reflejo de algo
            12-2/13/H/LAPICERO/Sirve para escribir,contiene tinta
            13-12/14/H/OESTE/Contrario al punto cardinal Este
            """,
            """
            18-17
            0-5/1/V/COBIJA/Tela que sirve para quitar el frio
            3-1/2/V/PUERTA/Sirve para cerrar o abrir un espacio como un cuarto o una casa
            5-0/3/H/CELULAR/Sirve para recibir y enviar mensajes o llamadas
            5-6/4/V/REZAR/Dar gracias a Dios
            6-8/5/V/PASATIEMPO/Actividad que sirve para entretenerse y pasar el rato
            7-8/6/H/AUDIFONOS/Utilizan cable o son inalambricos, sirven para escuchar musica de forma privada
            9-5/7/H/ARMARIO/Mueble que sirve para almacenar ropa u otras cosas
            10-13/8/V/LAPICERO/Utensilio utilizado para escribir
            10-16/9/V/LAMPARA/Utiliza un bombillo para dispersar luz
            11-5/10/H/MONITOREAR/Tener bajo vigilancia un area o sector
            13-6/11/H/COMER/Accion de ingerir alimentos
            15-10/12/H/EMPEZAR/Dar por iniciada una accion
            """
        };

    }
    
    /**
     * This method gets the information of the  different easy crosswords
     * information
     * @return It returns the information of the vector
     * @param level: receive the level elected by the user
     * @param crosswordNumber: receive the number of the crossword to show
     **/
    public String getCrossword(String level, int crosswordNumber) {
        if (level == "easy") {
            return this.getEasyCrosswords()[crosswordNumber];
        } else if (level == "medium") {
            return this.getMediumCrosswords()[crosswordNumber];
        } else if (level == "hard") {
            return this.getHardCrosswords()[crosswordNumber];
        } else {
            return null;
        }
    }
}
