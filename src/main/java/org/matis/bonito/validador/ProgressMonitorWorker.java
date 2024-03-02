/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.matis.bonito.validador;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;

/**
 *
 * @author oscar
 */
public class ProgressMonitorWorker extends SwingWorker<Void, Void> {
    
    private JDialog parentDialog;
    private JButton startButton;
    private ProgressMonitor progressMonitor;

    public ProgressMonitorWorker(JDialog parentDialog, JButton startButton) {
        this.parentDialog = parentDialog;
        this.startButton = startButton;
    }

    @Override
    protected Void doInBackground() throws Exception {
        // Simular una tarea larga
        for (int i = 0; i <= 100; i++) {
            // Comprobar si el usuario ha cancelado la tarea
            if (isCancelled()) {
                break;
            }
            // Actualizar el progreso
            setProgress(i);
            Thread.sleep(50); // Simular trabajo
        }
        return null;
    }

    public void startTask() {
        // Deshabilitar el botón de inicio cuando se inicia el monitor
        startButton.setEnabled(false);
        
        // Crear un ProgressMonitor para monitorear la tarea
        progressMonitor = new ProgressMonitor(parentDialog, "Task Progress", "", 0, 100);
        progressMonitor.setProgress(0); // Establecer el progreso inicial
        progressMonitor.setMillisToPopup(500); // Retardo de 500 milisegundos antes de mostrar el monitor

        // Ejecutar la tarea
        execute();

        // Agregar un listener de cambio de propiedad al SwingWorker
        addPropertyChangeListener((PropertyChangeEvent evt) -> {
            if ("state".equals(evt.getPropertyName()) && SwingWorker.StateValue.DONE.equals(evt.getNewValue())) {
                // Cuando la tarea está terminada, habilitar el botón de inicio
                startButton.setEnabled(true);
            }
        });
    }

    public void cancelTask() {
        cancel(true); // Cancelar la tarea en segundo plano
        progressMonitor.close(); // Cerrar el ProgressMonitor
    }
}
