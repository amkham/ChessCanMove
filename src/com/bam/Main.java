package com.bam;

import java.util.Arrays;
import java.util.List;

public class Main {

    ;

    public static void main(String[] args) {

        System.out.println("King test: ");
        System.out.println(canMove(ChessType.KING, "C3", "C4"));
        System.out.println(canMove(ChessType.KING, "C3", "D3"));
        System.out.println(canMove(ChessType.KING, "C2", "E3"));
        System.out.println(canMove(ChessType.KING, "C3", "E5"));


        System.out.println("Pawn test: ");
        System.out.println(canMove(ChessType.PAWN, "C3", "C4"));
        System.out.println(canMove(ChessType.PAWN, "C3", "C2"));
        System.out.println(canMove(ChessType.PAWN, "C3", "E4"));
        System.out.println(canMove(ChessType.PAWN, "C3", "B3"));

        System.out.println("Rook test: ");
        System.out.println(canMove(ChessType.ROOK, "C3", "C8"));
        System.out.println(canMove(ChessType.ROOK, "C3", "D4"));
        System.out.println(canMove(ChessType.ROOK, "D3", "D1"));
        System.out.println(canMove(ChessType.ROOK, "C3", "A1"));
        System.out.println(canMove(ChessType.ROOK, "C3", "G4"));


        System.out.println("Knight test: ");
        System.out.println(canMove(ChessType.KNIGHT, "C3", "C8"));
        System.out.println(canMove(ChessType.KNIGHT, "C3", "D4"));
        System.out.println(canMove(ChessType.KNIGHT, "C3", "E4"));
        System.out.println(canMove(ChessType.KNIGHT, "C3", "B1"));

        System.out.println("Bishop test: ");
        System.out.println(canMove(ChessType.BISHOP, "C3", "C8"));
        System.out.println(canMove(ChessType.BISHOP, "C3", "D4"));
        System.out.println(canMove(ChessType.BISHOP, "D3", "D1"));
        System.out.println(canMove(ChessType.BISHOP, "C3", "A1"));
        System.out.println(canMove(ChessType.BISHOP, "C3", "G4"));

        System.out.println("Queen test: ");
        System.out.println(canMove(ChessType.QUEEN, "D3", "D1"));
        System.out.println(canMove(ChessType.QUEEN, "C3", "A1"));
        System.out.println(canMove(ChessType.QUEEN, "D3", "D1"));
        System.out.println(canMove(ChessType.QUEEN, "C3", "A1"));
        System.out.println(canMove(ChessType.QUEEN, "C2", "E3"));
        System.out.println(canMove(ChessType.QUEEN, "C3", "E5"));




    }

    public static boolean canMove(ChessType chessType, String from, String to)
    {
        boolean _result = false;

        switch (chessType){
            case KING -> {_result = kingCheck(from, to);
            }
            case QUEEN -> {_result = queenCheck(from, to);
            }
            case BISHOP -> {_result = bishopCheck(from, to);
            }
            case ROOK -> {_result = rookCheck(from, to);
            }
            case KNIGHT -> {_result = knightCheck(from, to);
            }
            case PAWN -> {_result = pawnCheck(from, to);
            }

        }

        return _result;
    }

    private static boolean pawnCheck(String from, String to) {
        int[] _fromCoordinates = convertCoordinateToInt(from);
        int[] _toCoordinate = convertCoordinateToInt(to);

        return _toCoordinate[1] - _fromCoordinates[1] == 1 && _fromCoordinates[0] - _toCoordinate[0] == 0;
    }

    private static boolean knightCheck(String from, String to) {
        int[] _fromCoordinates = convertCoordinateToInt(from);
        int[] _toCoordinate = convertCoordinateToInt(to);

        return (Math.abs(_fromCoordinates[0] - _toCoordinate[0]) == 1 && Math.abs(_fromCoordinates[1] - _toCoordinate[1]) == 2) ||
                (Math.abs(_fromCoordinates[0] - _toCoordinate[0]) == 2 && Math.abs(_fromCoordinates[1] - _toCoordinate[1]) == 1);
    }



    private static boolean rookCheck(String from, String to) {
        int[] _fromCoordinates = convertCoordinateToInt(from);
        int[] _toCoordinate = convertCoordinateToInt(to);

        return _fromCoordinates[0] - _toCoordinate[0] == 0 || _fromCoordinates[1] - _toCoordinate[1] == 0;

    }

    private static boolean bishopCheck(String from, String to) {
        int[] _fromCoordinates = convertCoordinateToInt(from);
        int[] _toCoordinate = convertCoordinateToInt(to);

        return _fromCoordinates[0] - _toCoordinate[0] == _fromCoordinates[1] - _toCoordinate[1];
    }

    private static boolean queenCheck(String from, String to) {

        return rookCheck(from, to) || bishopCheck(from, to);
    }

    private static boolean kingCheck(String from, String to) {

        int[] _fromCoordinates = convertCoordinateToInt(from);
        int[] _toCoordinate = convertCoordinateToInt(to);

        return Math.abs(_fromCoordinates[0] - _toCoordinate[0]) < 2 && Math.abs(_fromCoordinates[1] - _toCoordinate[1]) < 2 ;
    }

    private static int[] convertCoordinateToInt(String from) {


        char[] _figureCharCoordinate = from.toCharArray();
        char[] _horizontalCharCoordinate = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        int[] _result = new int[2];
        _result[1] = Integer.parseInt(String.valueOf(_figureCharCoordinate[1]));

        for (int i = 0; i < _horizontalCharCoordinate.length; i++) {
            if (_figureCharCoordinate[0] == _horizontalCharCoordinate[i])
            {
                _result[0] = i;
                break;
            }
        }
        return _result;
    }
}
