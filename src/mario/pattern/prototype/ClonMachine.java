/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.pattern.prototype;

/**
 *
 * @author Mario
 */
public class ClonMachine {

    public ClonMachine() {
    }

    public ClonableBody createCopy(ClonableBody temp) {
        return temp.duplicate();
    }

    public ClonableBody[] createManyCopies(int n, ClonableBody temp) {
        ClonableBody[] res = new ClonableBody[n];
        for (int i = 0; i < n; i++) {
            res[i] = temp.duplicate();
        }
        return res;
    }
}
