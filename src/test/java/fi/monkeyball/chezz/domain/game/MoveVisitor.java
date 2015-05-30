package fi.monkeyball.chezz.domain.game;

/**
 * Created by juho on 30/05/15.
 */
public interface MoveVisitor {
    void visit(Giveup giveup);
    void visit(StandardMove giveup);
}
