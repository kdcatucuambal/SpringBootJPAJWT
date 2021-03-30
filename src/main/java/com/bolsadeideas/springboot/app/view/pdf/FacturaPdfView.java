package com.bolsadeideas.springboot.app.view.pdf;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("factura/ver")
public class FacturaPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("************** PDF RUN ***********");
		Factura factura = (Factura) model.get("factura");
		PdfPTable table = new PdfPTable(1);
		table.setSpacingAfter(20);

		PdfPCell cell = null;

		cell = new PdfPCell(new Phrase("Datos del cliente"));
		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setPadding(8f);

		table.addCell(cell);

		table.addCell(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
		table.addCell(factura.getCliente().getEmail());
		PdfPTable table2 = new PdfPTable(1);
		table2.setSpacingAfter(20);

		cell = new PdfPCell(new Phrase("Datos de la factura"));
		cell.setBackgroundColor(new Color(195, 230, 255));
		cell.setPadding(8f);

		table2.addCell(cell);
		table2.addCell("Id: " + factura.getId());
		table2.addCell("Descripción: " + factura.getDescripcion());
		table2.addCell("Fecha: " + factura.getCreateAt());

		document.add(table);
		document.add(table2);

		PdfPTable table3 = new PdfPTable(4);

		table3.setWidths(new float[] { 3.5f, 1, 1, 1 });
		Phrase header = new Phrase(new Chunk("Producto", FontFactory.getFont(FontFactory.COURIER, 11, Font.BOLD)));
		table3.addCell(header);
		table3.addCell("Precio");
		table3.addCell("Cantidad");
		table3.addCell("Total");

		for (ItemFactura item : factura.getItems()) {
			table3.addCell(item.getProducto().getNombre());
			table3.addCell(item.getProducto().getPrecio().toString());

			cell = new PdfPCell(new Phrase(item.getCantidad().toString()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			table3.addCell(cell);
			table3.addCell(item.calcularImporte().toString());
		}

		Phrase phrase5 = new Phrase(
				new Chunk("Total a Pagar: ", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));

		new Phrase();

		Phrase s = new Phrase("Total a Pagar: ");
		Font f = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, new Color(255, 0, 0));
		s.setFont(f);
		cell = new PdfPCell(phrase5);
		cell.setColspan(3);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

		table3.addCell(cell);
		table3.addCell(factura.getTotal().toString());

		document.add(table3);
		document.addHeader("has", "empres");
		document.setPageSize(PageSize.ARCH_B);

	}

}
