package edu.mermet.tp8.fenetres;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import edu.mermet.tp8.Application;

/**
 *
 * @author brunomermet
 */
public class FenetreConversion extends AbstractFenetreInterne {
    private JTextField champCelsius;
    private JTextField champFarenheit;
    private JButton boutonConvertir;
    private Action actionConvertir;
    private boolean celsiusAFocus;
    public FenetreConversion(Action action) {
        super(action,"Conversion celsius/Farenheit");
        this.setSize(new Dimension(100,50));
        this.setLayout(new GridLayout(3,1));
        JPanel ligneCelsius = new JPanel();
        ligneCelsius.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JLabel labCelsius = new JLabel("Celsius :");
        champCelsius = new JTextField(15);
        champCelsius.setToolTipText("Valeur en degrÃ© Celsius");
        labCelsius.setLabelFor(champCelsius);
        ImageIcon interrogation=new ImageIcon("ressources/interrogation.png");
        JLabel labAideC=new JLabel(interrogation);
        labAideC.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		super.mouseClicked(e);
        		JOptionPane.showMessageDialog(labAideC,"Valeur en degrÃ© Celsius" , "Aide", JOptionPane.INFORMATION_MESSAGE);
        	}
		});
        ligneCelsius.add(labCelsius);
        ligneCelsius.add(champCelsius);
        ligneCelsius.add(labAideC);
        this.add(ligneCelsius);
        celsiusAFocus = true;
        champCelsius.addFocusListener(new EcouteurFocus(true));
        JPanel ligneFarenheit = new JPanel();
        ligneFarenheit.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JLabel labFarenheit = new JLabel("Farenheit :");
        champFarenheit = new JTextField(15);
        champFarenheit.setToolTipText("Valeur en degrÃ© Farenheit");
        labFarenheit.setLabelFor(champFarenheit);
        JLabel labAideF=new JLabel(interrogation);
        labAideF.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		super.mouseClicked(e);
        		JOptionPane.showMessageDialog(labAideF,"Valeur en degrÃ© Farenheit" , "Aide", JOptionPane.INFORMATION_MESSAGE);
        	}
		});
        ligneFarenheit.add(labFarenheit);
        ligneFarenheit.add(champFarenheit);
        ligneFarenheit.add(labAideF);
        this.add(ligneFarenheit);
        champFarenheit.addFocusListener(new EcouteurFocus(false));
        JPanel ligneValider = new JPanel();
        ligneValider.setLayout(new FlowLayout(FlowLayout.CENTER));
        actionConvertir = new ActionConvertir();
        boutonConvertir = new JButton(actionConvertir);
        boutonConvertir.setToolTipText("Convertir les valeurs");
        ligneValider.add(boutonConvertir);
        this.add(ligneValider);
        
        pack();
        getRootPane().setDefaultButton(boutonConvertir);
    }

    private class EcouteurFocus implements FocusListener {
        private boolean aStocker;

        public EcouteurFocus(boolean b) {
            aStocker = b;
        }

        @Override
        public void focusGained(FocusEvent fe) {
            celsiusAFocus = aStocker;
        }

        @Override
        public void focusLost(FocusEvent fe) {
            return;
        }
    }

    private class ActionConvertir extends AbstractAction {

        public ActionConvertir() {
            super("Convertir");
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            double tempCelsius = 0;
            double tempFarenheit = 0;
            if (celsiusAFocus) {
                try {
                    tempCelsius = Double.parseDouble(champCelsius.getText());
                tempFarenheit = 9./5*tempCelsius+32;
                champFarenheit.setText(""+tempFarenheit);
                }
                catch (NumberFormatException nfe) {
                    champFarenheit.setText("Format incorrect");
                }
                }
            else {
                try {
                    tempFarenheit = Double.parseDouble(champFarenheit.getText());
                    tempCelsius = (tempFarenheit - 32) *5./9;
                    champCelsius.setText(""+tempCelsius);
                }
                catch (NumberFormatException nfe) {
                    champCelsius.setText("Format incorrect");
                }
                
            }
        }
    }
    
}