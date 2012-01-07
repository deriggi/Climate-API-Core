/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shapefileloader;

import org.opengis.feature.Feature;
import sdnis.wb.util.ShapeWrappers;

/**
 *
 * @author wb385924
 */
public interface FeatureHandler {

    public void handleFeature(/**String path,**/ShapeWrappers wrapper);
//    public void handleFeature(ShapeWrappers wrapper);

}
