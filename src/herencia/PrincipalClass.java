
package herencia;

/**
 *
 * @author Danny Jimenez
 */
public class PrincipalClass {
    
    
    public static Inicio principalWindow = new Inicio();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        //principalWindow.setExtendedState(principalWindow.MAXIMIZED_BOTH);
        principalWindow.setVisible(true);
        
        
        
    }
    
}
