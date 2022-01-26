package control;

/**
 * Contrôleur bouchon pour tester l'IHM du jeu Numberlink 
 * 
 * Cette classe ne sert qu'à tester que l'IHM est fonctionnellle en 
 * remplaçant le modèle métier par un bouchon qui retourne des réponses 
 * pré-définies.
 * 
 * @author Dominique Marcadet
 * @version 1.2
 *
 */
public class ControllerStub implements IController {
    
    @Override
    public boolean clickCell( int ligne, int colonne ) {
        System.out.println("clic en l" + ligne + "c" + colonne);
        if(( ligne == 0 ) && ( colonne % 2 == 0 )) return true;
        if(( ligne == 1 ) && (( colonne == 2 ) || ( colonne == 4 ))) return true;
        if(( ligne == 3 ) && ( colonne % 2 == 1 )) return true;
        if(( ligne == 4 ) && ( colonne > 0 ) && ( colonne < 4 )) return true;
        return false;
    }

    @Override
    public boolean action( Direction direction ) {
        System.out.println("f�che " + direction.name());
        return false;
    }

    @Override
    public int getNbLines() {
        return 5;
    }

    @Override
    public int getNbColumns() {
        return 5;
    }

    @Override
    public int getNbTags() {
        return 5;
    }

    @Override
    public int[] getStartPathPosition( int tag ) {
        return switch( tag ) {
            case 0 -> new int[] { 0, 0 };
            case 1 -> new int[] { 1, 4 };
            case 2 -> new int[] { 1, 2 };
            case 3 -> new int[] { 0, 2 };
            case 4 -> new int[] { 0, 4 };
            default -> null;
        };
    }

    @Override
    public int[] getSecondEndPosition( int tag ) {
        return switch( tag ) {
            case 0  -> new int[] { 4, 1 };
            case 1 -> new int[] { 4, 3 };
            case 2   -> new int[] { 4, 2 };
            case 3   -> new int[] { 3, 1 };
            case 4  -> new int[] { 3, 3 };
            default -> null;
        };
    }

    @Override
    public Direction[] getDirections( int tag ) {
        return switch( tag ) {
            case 0  -> new Direction[] { Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.LEFT };
            case 1 -> new Direction[] { Direction.DOWN, Direction.DOWN, Direction.DOWN };
            case 2   -> new Direction[] { Direction.DOWN, Direction.DOWN };
            case 3   -> new Direction[] { Direction.LEFT };
            case 4  -> new Direction[] { Direction.LEFT, Direction.DOWN, Direction.DOWN };
            default -> null;
        };
    }
}
