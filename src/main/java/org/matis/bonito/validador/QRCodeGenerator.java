package org.matis.bonito.validador;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import static com.google.zxing.BarcodeFormat.QR_CODE;
import static com.google.zxing.EncodeHintType.ERROR_CORRECTION;
import static com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class QRCodeGenerator {

    @NotNull
    public static BufferedImage generateQRCode(String text, int width, int height) throws WriterException {
        var hints = new HashMap<EncodeHintType, Object>();
        hints.put(ERROR_CORRECTION, H);

        var qrCodeWriter = new QRCodeWriter();
        var bitMatrix = qrCodeWriter.encode(text, QR_CODE, width, height, hints);
        var qrWidth = bitMatrix.getWidth();
        var qrHeight = bitMatrix.getHeight();

        var qrImage = new BufferedImage(qrWidth, qrHeight, TYPE_INT_RGB);
        qrImage.createGraphics();

        Graphics2D graphics = (Graphics2D) qrImage.getGraphics();
        graphics.setColor(WHITE);
        graphics.fillRect(0, 0, qrWidth, qrHeight);
        graphics.setColor(BLACK);

        for (int x = 0; x < qrWidth; x++) {
            for (int y = 0; y < qrHeight; y++) {
                if (bitMatrix.get(x, y)) {
                    graphics.fillRect(x, y, 1, 1);
                }
            }
        }
        return qrImage;
    }
}
