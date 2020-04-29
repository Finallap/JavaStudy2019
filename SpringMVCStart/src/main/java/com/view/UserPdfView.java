package com.view;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @description: UserPdfView
 * @date: 2020/4/29 18:36
 * @author: Finallap
 * @version: 1.0
 */
public class UserPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document,
                                    PdfWriter pdfWriter, HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {
        Map<String, String> userData = (Map<String, String>) map.get("userData");

        Table table = new Table(2);
        table.addCell("No.");
        table.addCell("User name");

        for (Map.Entry<String, String> entry : userData.entrySet()) {
            table.addCell(entry.getKey());
            table.addCell(entry.getValue());
        }

        document.add(table);
    }
}
