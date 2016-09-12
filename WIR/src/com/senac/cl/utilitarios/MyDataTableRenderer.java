package com.senac.cl.utilitarios;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.component.api.UIData;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.datatable.DataTableRenderer;
import org.primefaces.component.paginator.PaginatorElementRenderer;

public class MyDataTableRenderer extends DataTableRenderer {

//    
//    protected void encodePaginatorMarkup(FacesContext context, DataTable table, String position, String tag, String styleClass,UIData uidata) throws IOException {
//    	 if(!uidata.isPaginatorAlwaysVisible() && uidata.getPageCount() <= 1) {
//             return;
//         }
//         
//         ResponseWriter writer = context.getResponseWriter();
//         boolean isTop = position.equals("top");
//         
//         String styleClass1 = isTop ? UIData.PAGINATOR_TOP_CONTAINER_CLASS : UIData.PAGINATOR_BOTTOM_CONTAINER_CLASS;
//         String id = uidata.getClientId(context) + "_paginator_" + position; 
//         
//         //add corners
//         if(!isTop && uidata.getFooter() == null) {
//             styleClass1 = styleClass1 + " ui-corner-bottom";
//         }
//
//         writer.startElement("div", null);
//         writer.writeAttribute("id", id, null);
//         writer.writeAttribute("class", styleClass1, null);
//         writer.writeAttribute("role", "navigation", null);
//         
//         String[] elements = uidata.getPaginatorTemplate().split(" ");
//         for(String element : elements) {            
//             PaginatorElementRenderer renderer = PAGINATOR_ELEMENTS.get(element);
//             if(renderer != null) {
//                 renderer.render(context, uidata);
//             } 
//             else {
//                 UIComponent elementFacet = uidata.getFacet(element);
//                 if(elementFacet != null)
//                     elementFacet.encodeAll(context);
//                 else
//                     writer.write(element + " ");
//             }
//         }
//
//         writer.endElement("div");
//     }
//

}