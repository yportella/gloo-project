package boundary;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JPanel;

import numberlink.control.Direction;
import numberlink.control.IController;

/**
 * Panneau de l'IHM pour le jeu Numberlink
 * 
 * @author Dominique Marcadet
 * @version 1.2
 *
 */
@SuppressWarnings("serial")
public class NumberlinkPanel extends JPanel implements MouseListener {

    private static final float SELECTED_WIDTH = 4;
    private boolean firstDisplay = true;
    private IController controller;
    private int cellSize;
    private int endDiameter;
    private int halfRadius;
    private int pathWidth;
    private int arcRoundRect;
    private int[] selection;

    /**
     * Initialise le panneau d'affichage du jeu.
     * Le panneau est responsable de l'affichage de l'état du jeu et
     * de la transmission au contrôleur des cases cliquées.
     * 
     * @param controller le contrôleur qu'il faut informer des clics de
     *                   l'utilisateur dans les cases du jeu
     */
    public NumberlinkPanel( IController controller ) {
        this.controller = controller;
        this.addMouseListener( this );
    }

    private void computeParameters() {
        int cellHeight = getSize().height / controller.getNbLines();
        int cellWidth = getSize().width / controller.getNbColumns();
        cellSize = cellHeight < cellWidth ? cellHeight : cellWidth;
        endDiameter = cellSize * 2 / 3;
        halfRadius = endDiameter / 4;
        pathWidth = cellSize / 4;
        arcRoundRect = cellSize / 4;
        firstDisplay = false;
    }

    @Override
    public void paint( Graphics g ) {
        super.paint( g );
        
        if( firstDisplay ) computeParameters();

        // Le côté métier raisonne en [ligne, colonne]
        // Le côté IHM raisonne en [x, y]
        // Donc x <=> colonne et y <=> ligne
        for( int i = 0; i <= controller.getNbLines(); ++i ) {
            g.drawLine( 0, i * cellSize, controller.getNbColumns() * cellSize, i * cellSize );
        }
        for( int j = 0; j <= controller.getNbColumns(); ++j ) {
            g.drawLine( j * cellSize, 0, j * cellSize, controller.getNbLines() * cellSize );
        }

        for( int tag = 0; tag < controller.getNbTags(); ++tag ) {
            setColorForTag( g, tag );
            // Affichage de la première extrémité
            int[] startPos = controller.getStartPathPosition( tag );
            g.fillOval( startPos[1] * cellSize + halfRadius,
                    startPos[0] * cellSize + halfRadius,
                    endDiameter, endDiameter );
            // Décoration de l'extrémité si elle est sélectionnée
            if( Arrays.equals( startPos, selection )) {
                showSelectedEnd( g, startPos );
            }
            // Affichage de l'éventuel chemin partant de cette extrémité
            paintDirections( g, startPos, controller.getDirections( tag ));
            // Affichage de la seconde extrémité
            int[] endPos = controller.getSecondEndPosition( tag );
            g.fillOval( endPos[1] * cellSize + halfRadius,
                    endPos[0] * cellSize + halfRadius,
                    endDiameter, endDiameter );
            // Décoration de l'extrémité si elle est sélectionnée
            if( Arrays.equals( endPos, selection )) {
                showSelectedEnd( g, endPos );
            }
        }
    }

	private void showSelectedEnd(Graphics g, int[] startPos) {
		Color c = g.getColor();
		g.setColor( Color.BLACK );
		Graphics2D g2 = ( Graphics2D ) g;
		Stroke s = g2.getStroke();
		g2.setStroke( new BasicStroke( SELECTED_WIDTH ));
		g.drawOval( startPos[1] * cellSize + halfRadius,
		        startPos[0] * cellSize + halfRadius,
		        endDiameter, endDiameter );
		g2.setStroke( s );
		g.setColor( c );
	}

    private void paintDirections( Graphics g, int[] startPos, Direction[] directions ) {
        // Ici :
        // x <=> startPos[1] et y <=> startPos[0]
        int x0 = startPos[1] * cellSize + cellSize / 2 - pathWidth / 2;
        int y0 = startPos[0] * cellSize + cellSize / 2 - pathWidth / 2;
        for( Direction dir : directions ) {
            int w = pathWidth;
            int h = pathWidth;
            int x1 = x0;
            int y1 = y0;
            switch( dir ) {
            case UP:
                y0 -= cellSize;
                y1 -= cellSize;
                h += cellSize;
                break;
            case DOWN:
                h += cellSize;
                y1 += cellSize;
                break;
            case LEFT:
                x0 -= cellSize;
                x1 -= cellSize;
                w += cellSize;
                break;
            case RIGHT:
                w += cellSize;
                x1 += cellSize;
                break;
            }
            g.fillRoundRect( x0, y0, w, h, arcRoundRect, arcRoundRect );
            x0 = x1;
            y0 = y1;
        }
    }

    private void setColorForTag( Graphics g, int tag ) {
        g.setColor( switch( tag ) {
            case 0  -> Color.RED;
            case 1  -> Color.ORANGE;
            case 2  -> Color.BLUE;
            case 3  -> Color.GREEN;
            case 4  -> Color.YELLOW;
            case 5  -> Color.MAGENTA;
            case 6  -> Color.CYAN;
            case 7  -> Color.PINK;
            case 8  -> Color.LIGHT_GRAY;
            case 9  -> Color.GRAY;
            case 10 -> Color.DARK_GRAY;
            case 11 -> Color.BLACK;
            default -> throw new IllegalArgumentException( "L'IHM ne peut pas afficher plus de 12 �tiquettes diff�rentes" );
        } );
    }

    @Override
    public void mouseClicked( MouseEvent e ) {
        if( controller.clickCell( e.getPoint().y / cellSize, e.getPoint().x / cellSize )) {
            selection = new int[] { e.getPoint().y / cellSize, e.getPoint().x / cellSize };
        }
        repaint();
    }

    @Override
    public void mousePressed( MouseEvent e ) {
        // nothing
    }

    @Override
    public void mouseReleased( MouseEvent e ) {
        // nothing
    }

    @Override
    public void mouseEntered( MouseEvent e ) {
        // nothing
    }

    @Override
    public void mouseExited( MouseEvent e ) {
        // nothing
    }
}
