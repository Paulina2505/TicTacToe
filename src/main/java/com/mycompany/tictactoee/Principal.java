package com.mycompany.tictactoee;

import static javax.swing.JOptionPane.*;

public class Principal {
    private static String[] tictactoe = new String[9];
    private static String[] tictactoeAux = new String[9];
    private static int[] valores = new int[8];
    private static boolean termino = false;
    private static boolean terminaTurno = false;
    private static int posicion = -1;
    private static int posicion2 = -1;
    private static int posicion3 = -1;
    private static int posicion4 = -1;
    
    public static void main(String[] args) {
        iniciaJuego();
        int inicio = Integer.parseInt(showInputDialog("¿Quién inicia?\nMáquina(0), Yo(1)"));
        do {
            if (inicio == 0) {
                sacarUtilidad();
                sucesor();
                inicio = 1;
                imprimeTTT(tictactoe);
                //imprimeTTT(valores);
            } else {
                turnoUsuario();
                sacarUtilidad();
                inicio = 0;
                imprimeTTT(tictactoe);
                //imprimeTTT(valores);
            }
            if (terminal(tictactoe, "X")) {
                termino = true;
                showMessageDialog(null, "¡GANÓ X!");
            } else if (terminal(tictactoe, "O")) {
                termino = true;
                showMessageDialog(null, "¡GANASTE, FELICIDADES!");
            } else if (empate()) {
                termino = true;
                showMessageDialog(null, "¡EMPATE!");
            }
        } while (!termino);
    }
    
    static void iniciaJuego() {
        for (int i = 0; i < tictactoe.length; i++) {
            tictactoe[i] = "_";
        }
    }
    
    static void imprimeTTT(String[] tictactoe) {
        String salida = "";
        for (int i = 0; i < tictactoe.length; i++) {
            salida += tictactoe[i]+"|";
            if (i == 2 || i == 5 || i == 8) salida += "\n";
        }
        showMessageDialog(null, salida);
    }
    
    static void imprimeTTT(int[] tictactoe) {
        String salida = "";
        for (int i = 0; i < tictactoe.length; i++) {
            salida += tictactoe[i]+"|";
            if (i == 2 || i == 5 || i == 8) salida += "\n";
        }
        showMessageDialog(null, salida);
    }
    
    static void turnoUsuario() {
        terminaTurno = false;
        do {
            String tablero = "0|1|2\n3|4|5\n6|7|8";
            int posicion = Integer.parseInt(showInputDialog(tablero + "\nIngresa tu tirada:"));
            if (!tictactoe[posicion].equalsIgnoreCase("_")) {
                showMessageDialog(null, "Esta posición ya está ocupada, elije otra");
            } else {
                tictactoe[posicion] = "O";
                terminaTurno = true;
            }
        } while (!terminaTurno);    
    }
    
    static String[] clonar(String[] original){
        String[] copia = new String[9];
        for (int i = 0; i < original.length; i++) {
                copia[i] = original[i];
        }
        return copia;
    }
    
    static boolean terminal(String[] tablero, String turno) {
        for (int i = 0; i < tablero.length; i = i+3) {
            if (tablero[i].equals(turno) && tablero[i+1].equals(turno) && tablero[i+2].equals(turno)) return true;
        }
        for (int i = 0; i < 3; i++) {
            if (tablero[i].equals(turno) && tablero[i+3].equals(turno) && tablero[i+6].equals(turno)) return true;
        }
        if (tablero[0].equals(turno) && tablero[4].equals(turno) && tablero[8].equals(turno)) return true;
        else if (tablero[2].equals(turno) && tablero[4].equals(turno) && tablero[6].equals(turno)) return true;
        else return false;
    }
    
    static boolean empate() {
        boolean empatamos = true;
        for (int i = 0; i < tictactoe.length; i++) {
            if (tictactoe[i].equals("_")) {
                empatamos = false;
                i = tictactoe.length;
            }
        }
        if (!empatamos) {
            empatamos = true;
            for (int i = 0; i < valores.length; i++) {
                if (valores.length > -9) {
                    empatamos = false;
                    i = valores.length;
                }
            }
        }
        return empatamos;
    }
    
    static void sacarUtilidad() {
        int o = 0;
        int x = 0;
        for (int i = 0; i < 3; i++) {
            if (tictactoe[i] == "O") o++;
            else if (tictactoe[i] == "X") x++;
        }
        if (x > 0 && o > 0) valores[0] = -9;
        else if (x > 0) valores[0] = x;
        else valores[0] = -o;
        
        o = 0; x = 0;
        for (int i = 3; i < 6; i++) {
            if (tictactoe[i] == "O") o++;
            else if (tictactoe[i] == "X") x++;
        }
        if (x > 0 && o > 0) valores[1] = -9;
        else if (x > 0) valores[1] = x;
        else valores[1] = -o;
        
        o = 0; x = 0;
        for (int i = 6; i < 9; i++) {
            if (tictactoe[i] == "O") o++;
            else if (tictactoe[i] == "X") x++;
        }
        if (x > 0 && o > 0) valores[2] = -9;
        else if (x > 0) valores[2] = x;
        else valores[2] = -o;
        
        o = 0; x = 0;
        for (int i = 0; i < 9; i=i+3) {
            if (tictactoe[i] == "O") o++;
            else if (tictactoe[i] == "X") x++;
        }
        if (x > 0 && o > 0) valores[3] = -9;
        else if (x > 0) valores[3] = x;
        else valores[3] = -o;
        
        o = 0; x = 0;
        for (int i = 1; i < 9; i=i+3) {
            if (tictactoe[i] == "O") o++;
            else if (tictactoe[i] == "X") x++;
        }
        if (x > 0 && o > 0) valores[4] = -9;
        else if (x > 0) valores[4] = x;
        else valores[4] = -o;
        
        o = 0; x = 0;
        for (int i = 2; i < 9; i=i+3) {
            if (tictactoe[i] == "O") o++;
            else if (tictactoe[i] == "X") x++;
        }
        if (x > 0 && o > 0) valores[5] = -9;
        else if (x > 0) valores[5] = x;
        else valores[5] = -o;
        
        o = 0; x = 0;
        for (int i = 0; i < 9; i=i+4) {
            if (tictactoe[i] == "O") o++;
            else if (tictactoe[i] == "X") x++;
        }
        if (x > 0 && o > 0) valores[6] = -9;
        else if (x > 0) valores[6] = x;
        else valores[6] = -o;
        
        o = 0; x = 0;
        for (int i = 2; i < 7; i=i+2) {
            if (tictactoe[i] == "O") o++;
            else if (tictactoe[i] == "X") x++;
        }
        if (x > 0 && o > 0) valores[7] = -9;
        else if (x > 0) valores[7] = x;
        else valores[7] = -o;
    }
    
    static void sucesor() {
        if (mata());
        else if (salva());
        else calculaJugada();
    }
    
    static boolean mata() {
        int aux = -1;
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == 2) {
                if (i == 0) for (int j = 0; j < 3; j++) tictactoe[j] = "X";
                else if (i == 1) for (int j = 3; j < 6; j++) tictactoe[j] = "X";
                else if (i == 2) for (int j = 6; j < 9; j++) tictactoe[j] = "X";
                else if (i == 3) for (int j = 0; j < 9; j=j+3) tictactoe[j] = "X";
                else if (i == 4) for (int j = 1; j < 9; j=j+3) tictactoe[j] = "X";
                else if (i == 5) for (int j = 2; j < 9; j=j+3) tictactoe[j] = "X";
                else if (i == 6) for (int j = 0; j < 9; j=j+4) tictactoe[j] = "X";
                else if (i == 7) for (int j = 2; j < 7; j=j+2) tictactoe[j] = "X";
                else return false;
                return true;
            }
        }
        return false;
    }
    
    static boolean salva() {
        int aux = -1;
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == -2) {
                if (i == 0) for (int j = 0; j < 3; j++) {if (tictactoe[j].equals("_")) tictactoe[j] = "X";}
                else if (i == 1) for (int j = 3; j < 6; j++) {if (tictactoe[j].equals("_")) tictactoe[j] = "X";}
                else if (i == 2) for (int j = 6; j < 9; j++) {if (tictactoe[j].equals("_")) tictactoe[j] = "X";}
                else if (i == 3) for (int j = 0; j < 9; j=j+3) {if (tictactoe[j].equals("_")) tictactoe[j] = "X";}
                else if (i == 4) for (int j = 1; j < 9; j=j+3) {if (tictactoe[j].equals("_")) tictactoe[j] = "X";}
                else if (i == 5) for (int j = 2; j < 9; j=j+3) {if (tictactoe[j].equals("_")) tictactoe[j] = "X";}
                else if (i == 6) for (int j = 0; j < 9; j=j+4) {if (tictactoe[j].equals("_")) tictactoe[j] = "X";}
                else if (i == 7) for (int j = 2; j < 7; j=j+2) {if (tictactoe[j].equals("_")) tictactoe[j] = "X";}
                else return false;
                return true;
            }
        }
        return false;
    }
    
    static boolean calculaJugada() {
        int[] v = new int[9];
        int position = -1;
        v[0] = valores[0] + valores[3] + valores[6];
        v[1] = valores[0] + valores[4];
        v[2] = valores[0] + valores[5] + valores[7];
        v[3] = valores[1] + valores[3];
        v[4] = valores[1] + valores[4] + valores[6] + valores[7];
        v[5] = valores[1] + valores[5];
        v[6] = valores[2] + valores[3] + valores[7];
        v[7] = valores[2] + valores[4];
        v[8] = valores[2] + valores[5] + valores[6];
        /*
        System.out.println("0: "+v[0]);
        System.out.println("1: "+v[1]);
        System.out.println("2: "+v[2]);
        System.out.println("3: "+v[3]);
        System.out.println("4: "+v[4]);
        System.out.println("5: "+v[5]);
        System.out.println("6: "+v[6]);
        System.out.println("7: "+v[7]);
        System.out.println("8: "+v[8]);
        */
        if (turnoMaquina()) {
            terminaTurno = false;
            if (posicion % 2 == 0) {
                if (position < 0) {
                    for (int i = 0; i < v.length; i++) {
                        if (v[i] == -2) {
                            if (tictactoe[i].equals("_")) {
                                if (posicion % 2 == 0) {
                                    position = i;
                                }
                            }
                        }
                    }
                }

                if (position < 0) {
                    for (int i = 0; i < v.length; i++) {
                        if (v[i] == -1) {
                            if (tictactoe[i].equals("_")) {
                                if (posicion % 2 == 0) {
                                    position = i;
                                }
                            }
                        }
                    }
                }

                if (position < 0) {
                    for (int i = 0; i < v.length; i++) {
                        if (v[i] == 0) {
                            if (tictactoe[i].equals("_")) {
                                if (posicion % 2 == 0) {
                                    position = i;
                                }
                            }
                        }
                    }
                }
            } else {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == 0) {
                        if (tictactoe[i].equals("_")) {
                            position = i;
                        }
                    }
                }

                if (position < 0) {
                    for (int i = 0; i < v.length; i++) {
                        if (v[i] == 1) {
                            if (tictactoe[i].equals("_")) {
                                position = i;
                            }
                        }
                    }
                }

                if (position < 0) {
                    for (int i = 0; i < v.length; i++) {
                        if (v[i] == -2) {
                            if (tictactoe[i].equals("_")) {
                                position = i;
                            }
                        }
                    }
                }

                if (position < 0) {
                    for (int i = 0; i < v.length; i++) {
                        if (v[i] == -3) {
                            if (tictactoe[i].equals("_")) {
                                position = i;
                            }
                        }
                    }
                }
            }

        } else {
            for (int i = 0; i < v.length; i++) {
                if (v[i] == 0) {
                    if (tictactoe[i].equals("_")) {
                        if (posicion % 2 == 0) {
                            position = i;
                        }
                    }
                }
            }

            if (position < 0) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == 1) {
                        if (tictactoe[i].equals("_")) {
                            if (posicion % 2 == 0) {
                                position = i;
                            }
                        }
                    }
                }
            }

            if (position < 0) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == -2) {
                        if (tictactoe[i].equals("_")) {
                            if (posicion % 2 == 0) {
                                position = i;
                            }
                        }
                    }
                }
            }

            if (position < 0) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == -3) {
                        if (tictactoe[i].equals("_")) {
                            if (posicion % 2 == 0) {
                                position = i;
                            }
                        }
                    }
                }
            }
        }
        if (tictactoe[4].equals("O")) {
            for (int i = 0; i < v.length; i++) {
                if (v[i] == -3) {
                    if (tictactoe[i].equals("_")) {
                        position = i;
                    }
                }
            }

            if (position < 0) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == -2) {
                        if (tictactoe[i].equals("_")) {
                            position = i;
                        }
                    }
                }
            }

            if (position < 0) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == -1) {
                        if (tictactoe[i].equals("_")) {
                            position = i;
                        }
                    }
                }
            }

            if (position < 0) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == 0) {
                        if (tictactoe[i].equals("_")) {
                            position = i;
                        }
                    }
                }
            }
        } else {
            if (position < -1) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == 0) {
                        if (tictactoe[i].equals("_")) {
                            position = i;
                        }
                    }
                }
            }

            if (position < 0) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == 1) {
                        if (tictactoe[i].equals("_")) {
                            position = i;
                        }
                    }
                }
            }

            if (position < 0) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == -2) {
                        if (tictactoe[i].equals("_")) {
                            position = i;
                        }
                    }
                }
            }

            if (position < 0) {
                for (int i = 0; i < v.length; i++) {
                    if (v[i] == -3) {
                        if (tictactoe[i].equals("_")) {
                            position = i;
                        }
                    }
                }
            }
        }

        if (posicion >= 0) {
            tictactoe[posicion] = "X";
            return true;
        } else if (position >= 0) {
            tictactoe[position] = "X";
            return true;
        } else 
            return false;
    }
    
    static boolean turnoMaquina() {
        posicion = -1;
        boolean listo = false;
        if (tictactoe[4].equals("_")) {
            posicion = 4;
        }else if (tictactoe[4].equals("O")) {
            if (tictactoe[0].equals("_") || tictactoe[2].equals("_") || tictactoe[6].equals("_") || tictactoe[8].equals("_")) {
                do {                
                    posicion = (int) Math.round(Math.random()*8);
                    if (posicion %2 == 0 && tictactoe[posicion].equals("_")) {
                        listo = true;
                    }
                } while (!listo);
            } else return false;
        } else {
            if (tictactoe[1].equals("_") || tictactoe[3].equals("_") || tictactoe[5].equals("_") || tictactoe[7].equals("_")) {
                do {              
                    posicion = (int) Math.round(Math.random()*8);
                    if (posicion %2 != 0 && tictactoe[posicion].equals("_")) {
                        listo = true;
                    }
                } while (!listo);
            } else return false;
        } 
        return true;
    }
}
