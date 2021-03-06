/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package netcdfloader;

import dao.GeoDao;
import database.DBUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucar.ma2.Array;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

/**
 *
 * @author wb385924
 */
public class PrecipitationLoader {

    private static Logger log = Logger.getLogger(PrecipitationLoader.class.getName());
    private final String LAT = "lat";
    private final String LON = "lon";
    private final String TIME = "time";
    private final String DAYS_SINCE = "days since";
    private final String MINUTES_SINCE = "minutes since";
    private String timeUnits = null;

    public static void main(String[] args) {



//        new PrecipitationLoader().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.CD18_BCSD_0.5_2deg_1961-1999.monthly.nc", 3, 1, "cooling_days");
        new PrecipitationLoader().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.R02_BCSD_0.5_2deg_1961-1999.monthly.nc", 3, 1, "wet_days");

//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.pr_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "pr");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.tasmax_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "tasmax");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.tasmin_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "tasmin");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.GD10_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "tasmin");
//
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.FD_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "fd");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.HD18_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "hd18");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.R02_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "r02");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.R90P_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "r90p");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.R90PTOT_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "r90ptot");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.SDII_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "sdii");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.TN10P_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "tn10p");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.TN90P_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "tn90p");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.TNN_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "tnn");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.TX10P_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "tx10p");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.TX90P_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "tx90p");
//        new NetCDFtoCSVConverter().readNCData("C:\\MASSIVE_DATA\\bccr\\out_stats\\bccr_bcm2_0.20c3m.run1.TXX_BCSD_0.5_2deg_1961-1999.monthly.nc", 2, 1, "txx");



//        new PrecipitationLoader().readNCData("D:\\WorldBankDaily\\bccr_bcm2_0\\out_stats\\bccr_bcm2_0.20c3m.run1.pr_BCSD_0.5_2deg_1961-1999.monthly.nc",2,1,"precipitation");

//        new PrecipitationLoader().readNCData("D:\\WorldBankDaily\\bccr_bcm2_0\\out_stats\\bccr_bcm2_0.20c3m.run1.R02_BCSD_0.5_2deg_1961-1999.monthly.nc",2,1,"wetdays");


        DBUtils.closeAll();
    }
    private HashMap<String, String> variableNameMap = new HashMap<String, String>();

    public PrecipitationLoader() {
        variableNameMap.put("precipitation", "pr");
        variableNameMap.put("tasmax", "tasmax");
        variableNameMap.put("tasmin", "tasmin");
        variableNameMap.put("wet_days", "r02");
        variableNameMap.put("cooling_days", "cd18");

    }

    private String getVariableName(String entityType) {
        return variableNameMap.get(entityType);
    }

    private Date computeThisDate(Date startDateForTime, Long time) {
        Calendar cal = Calendar.getInstance();
        if (timeUnits.equals(DAYS_SINCE)) {
            cal.setTimeInMillis(startDateForTime.getTime());
            cal.add(Calendar.DATE, time.intValue());
            cal.add(Calendar.DAY_OF_MONTH, -cal.get(Calendar.DAY_OF_MONTH) + 1);

            return cal.getTime();
        } else if (timeUnits.equals(MINUTES_SINCE)) {
            cal.setTimeInMillis(startDateForTime.getTime());
            cal.add(Calendar.MINUTE, time.intValue());
            cal.add(Calendar.DAY_OF_MONTH, -cal.get(Calendar.DAY_OF_MONTH) + 1);

            return cal.getTime();
        }
        return cal.getTime();
    }
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    private String formatDate(Date date) {
        return sdf.format(date);
    }

    private Date parseTimeUnits(String unitsString, SimpleDateFormat format) {
        String dateString = null;
        Date returnDate = null;
        try {
            if (unitsString.indexOf(DAYS_SINCE) != -1) {
                dateString = unitsString.substring(DAYS_SINCE.length()).trim();
                timeUnits = DAYS_SINCE;
                returnDate = format.parse(dateString);
            } else if (unitsString.indexOf(MINUTES_SINCE) != -1) {
                dateString = unitsString.substring(MINUTES_SINCE.length()).trim();
                timeUnits = MINUTES_SINCE;
                returnDate = format.parse(dateString);
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return returnDate;
    }

    private Date getStartDAte(NetcdfFile ncFile) {
        Date startDate = null;

//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");

//            String date = ncFile.findVariable(TIME).getUnitsString().substring(10).trim();
        startDate = parseTimeUnits(ncFile.findVariable(TIME).getUnitsString(), dateFormat);

        System.out.println("tried to parse " + startDate);
        System.out.println("time is " + startDate);



        return startDate;
    }

    public void readNCData(String filename, int scenarioId, int runNumber, String entityType) {
        NetcdfFile ncfile = null;

        try {
            // setup
            ncfile = NetcdfFile.open(filename);
            Variable data = null;
            List<Variable> variables = ncfile.getVariables();
            Date startDateForTime = getStartDAte(ncfile);

            int counter = 0;
            for (Variable v : variables) {

                int[] shape = v.getShape();
                if (shape.length == 3) {
                    System.out.println(counter++ + " This is our three dimensional variable");
                    System.out.println(v.getName().toString() + '\t' + v.getDimensionsString());
                    for (int i = 0; i < shape.length; i++) {
                        System.out.println(shape[i]);
                    }
                    data = v;
                }


            }


            // initialize origin and ranges
            int[] origin = {0, 0, 0};
            int[] offset = {1, 1, 1};
            int[] range = new int[3];
            for (int i = 0; i < range.length; i++) {

                range[i] = data.getDimension(i).getLength() - 1;
                System.out.println(data.getDimension(i).getName() + " max index is " + range[i]);
            }

            long t0 = 0;
            // part 3: iterate through the data
            for (origin[0] = 0; origin[0] < range[0]; origin[0]++) {
                t0 = new Date().getTime();
                for (origin[1] = 0; origin[1] < range[1]; origin[1]++) {

                    for (origin[2] = 0; origin[2] < range[2]; origin[2]++) {
                        // System.out.println("0 is " + variables.get(0).getName());
                        // double var0 = variables.get(0).read(new int[]{origin[0]}, new int[]{1}).getFloat(0);


//                        System.out.println("2 is " + variables.get(2).getName()  +  " " + variables.get(2).getNameAndDimensions());
                        double var2 = variables.get(2).read(new int[]{origin[0]}, new int[]{1}).getFloat(0);

//                        System.out.println("1 is " + variables.get(1).getName());
                        double var1 = variables.get(1).read(new int[]{origin[1]}, new int[]{1}).getFloat(0);

//                        System.out.println("0 is " + variables.get(0).getName());
                        double var0 = variables.get(0).read(new int[]{origin[2]}, new int[]{1}).getFloat(0);


                        // System.out.println("origin is " + origin[0] + " " + origin[1] + " " + origin[2]);
                        //System.out.println("value is " + data.read(origin, offset) + "at" + variables.get(1).getName()+" " + var1 + " " + var2 + " " /**+ var3**/);

                        String datavalstring = data.read(origin, offset).toString().trim();
                        if (!datavalstring.equals("1.0E20")) {

                            double dataval = Double.parseDouble(datavalstring);

                            HashMap<String, Double> variableMap = new HashMap<String, Double>();


                            variableMap.put(variables.get(3).getName(), dataval);
//                            System.out.println("storing " + variables.get(3).getNameAndDimensions() + " " + dataval);

                            variableMap.put(variables.get(0).getName(), var0);
//                            System.out.println("storing " + variables.get(1).getName() + " " + var1);

                            variableMap.put(variables.get(1).getName(), var1);
                            //System.out.println("storing " + variables.get(2).getName() + " " + var2);

                            variableMap.put(variables.get(2).getName(), var2);
                            // System.out.println("storing " + variables.get(3).getName() + " " + var3);



//                            if( (getCountryContainingPoint(var2, var3) == 537)){
//                                System.out.println("Found Country data");
//
//                                FileExportHelper.appendToFile("MOZ_" + filename.substring(filename.lastIndexOf("\\")+1,filename.lastIndexOf(".")) + ".txt"  ,dataval + "," + var1 + "," + var2 + "," + var3 + System.getProperty("line.separator"));
//
//                            }



                            storeStatistic(variableMap, startDateForTime, scenarioId, runNumber, entityType);



                        }


                    }

                }
                log.log(Level.INFO, "made it around the world in {0}", (new Date().getTime() - t0));

            }



        } catch (IOException ex) {
            Logger.getLogger(PrecipitationLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidRangeException ex) {
            Logger.getLogger(PrecipitationLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (null != ncfile) {
                try {
                    ncfile.close();
                } catch (IOException ioe) {
                    //log("trying to close " + filename, ioe);
                }
            }
        }

    }

    private double flipPostiveLongitude(double lon) {
        if (lon > 180) {
            return lon - 360;
        }
        return lon;
    }

//    private int getCountryContainingPoint(double latitude, double longitude) {
//        Connection c = DBUtils.getConnection();
//
//        int id = GeoDao.getIdOfRegionContainingPoint(c, latitude, longitude, "country_boundary", "shape", "country_id");
//
//        DBUtils.close(c);
//
//        return id;
//
//    }
    private String createQuery(String queryTemplate, String entityParameter) {

        return queryTemplate.replaceAll("\\@", entityParameter);
    }

    private void insertInitialStatisticRecord(int countryId, Date monthDate, int scenarioId, int runNumber, String entityParamter) {
        //String insertStatement = "insert into precipitation (precipitation_sum , precipitation_reading_count, precipitation_country_id, precipitation_date,  precipitation_scenario_id,precipitation_min,precipitation_max) values (?,?,?,?,?,?,?)";

        String insertStatement = "insert into @ (@_sum , @_count, @_area_id, @_date,  @_scenario_id,@_min,@_max, @_run) values (?,?,?,?,?,?,?,?)";

        insertStatement = createQuery(insertStatement, entityParamter);

        Connection c = DBUtils.getConnection();
        PreparedStatement ps = null;


        try {
            ps = c.prepareStatement(insertStatement);
            ps.setFloat(1, 0.0f);
            ps.setInt(2, 0);
            ps.setInt(3, countryId);
            ps.setDate(4, new java.sql.Date(monthDate.getTime()));
            ps.setInt(5, scenarioId);
            ps.setInt(6, 10000);
            ps.setInt(7, -10000);
            ps.setInt(8, runNumber);
            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(PrecipitationLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.close(ps);
        }


    }

    private void updateMaxStatistic(float precip, int countryId, Date monthDate, int scenarioId, int runNumber, String entityType) {
        //String update = "update precipitation set precipitation_max = ? where precipitation_country_id = ? and precipitation_date = ? and precipitation_scenario_id = ?";
        String update = "update @ set @_max = ? where @_area_id = ? and @_date = ? and @_scenario_id = ? and @_run = ?";

        update = createQuery(update, entityType);

        Connection c = DBUtils.getConnection();
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(update);
            ps.setFloat(1, precip);
            ps.setInt(2, countryId);
            ps.setDate(3, new java.sql.Date(monthDate.getTime()));
            ps.setInt(4, scenarioId);
            ps.setInt(5, runNumber);

            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();

        } finally {
            DBUtils.close(c, ps, null);
        }
    }

    private void updateMinStatistic(float precip, int countryId, Date monthDate, int scenarioId, int runNumber, String entityType) {
        //String update = "update precipitation set precipitation_min = ? where precipitation_country_id = ? and precipitation_date = ? and precipitation_scenario_id = ?";
        String update = "update @ set @_min = ? where @_area_id = ? and @_date = ? and @_scenario_id = ? and @_run = ?";
        update = createQuery(update, entityType);

        Connection c = DBUtils.getConnection();
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(update);
            ps.setFloat(1, precip);
            ps.setInt(2, countryId);
            ps.setDate(3, new java.sql.Date(monthDate.getTime()));
            ps.setInt(4, scenarioId);
            ps.setInt(5, runNumber);
            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();

        } finally {
            DBUtils.close(c, ps, null);
        }
    }

    private float getMaxStatistic(int countryId, Date monthDate, int scenarioId, int runNumber, String entityType) {
        String getMax = "select @_max from @ where @_date = ? and @_area_id = ? and @_scenario_id = ? and @_run = ?";

        getMax = createQuery(getMax, entityType);

        Connection c = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        float currentMax = -1;
        try {

            ps = c.prepareStatement(getMax);
            ps.setDate(1, new java.sql.Date(monthDate.getTime()));
            ps.setInt(2, countryId);
            ps.setInt(3, scenarioId);
            ps.setInt(4, runNumber);
            rs = ps.executeQuery();
            if (rs.next()) {
                currentMax = rs.getFloat(entityType + "_max");
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            DBUtils.close(c, ps, rs);
        }

        return currentMax;

    }

    private float getMinStatistic(int countryId, Date monthDate, int scenarioId, int runNumber, String entityType) {
        String getMax = "select @_min from @ where @_date = ? and @_area_id = ? and @_scenario_id = ? and @_run = ?";

        getMax = createQuery(getMax, entityType);

        Connection c = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        float currentMin = 10000;
        try {

            ps = c.prepareStatement(getMax);
            ps.setDate(1, new java.sql.Date(monthDate.getTime()));
            ps.setInt(2, countryId);
            ps.setInt(3, scenarioId);
            ps.setInt(4, runNumber);
            rs = ps.executeQuery();
            if (rs.next()) {
                currentMin = rs.getFloat(entityType + "_min");

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            DBUtils.close(c, ps, rs);
        }

        return currentMin;

    }

    private void updateStatisticRecord(int countryId, Date monthDate, float data, int scenarioId, int runNumber, String entityType) {
        //String query = "update precipitation set precipitation_sum = ( precipitation_sum + ? ), precipitation_reading_count = (precipitation_reading_count + 1) where precipitation_country_id = ? and precipitation_date = ? and precipitation_scenario_id = ?";

        String query = "update @ set @_sum = ( @_sum + ? ), @_count = (@_count + 1) where @_area_id = ? and @_date = ? and @_scenario_id = ? and @_run = ?";

        query = createQuery(query, entityType);

        Connection c = DBUtils.getConnection();
        PreparedStatement ps = null;


        try {
            ps = c.prepareStatement(query);
            ps.setFloat(1, data);
            ps.setInt(2, countryId);
            ps.setDate(3, new java.sql.Date(monthDate.getTime()));
            ps.setInt(4, scenarioId);
            ps.setInt(5, runNumber);
            ps.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(PrecipitationLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.close(ps);
        }
    }

    private boolean doesStatisticRecordExist(int countryId, Date monthDate, int scenarioId, int runNumber, String entityType) {
        //String query = "select count(*) from precipitation where precipitation_country_id = ? and precipitation_date = ? and precipitation_scenario_id = ?";
        String query = "select count(*) from @ where @_area_id = ? and @_date = ? and @_scenario_id = ? and @_run = ?";

        query = createQuery(query, entityType);


        Connection c = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, countryId);
            ps.setDate(2, new java.sql.Date(monthDate.getTime()));
            ps.setInt(3, scenarioId);
            ps.setInt(4, runNumber);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrecipitationLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.close(ps, rs);
        }
        return false;

    }

    private void storeStatistic(HashMap<String, Double> dataMap, Date startDateForTime, int scenarioId, int runNumber, String entityType) {
        Connection c = DBUtils.getConnection();
        StringBuilder sb = new StringBuilder();

        sb.append("POINT(");
        sb.append(flipPostiveLongitude(dataMap.get(LON)));
        sb.append(" ");
        sb.append(dataMap.get(LAT));
        sb.append(")");


        // get data reading
        String ncvarname = getVariableName(entityType);

        float precip = dataMap.get(ncvarname).floatValue();


         Date thisDate = computeThisDate(startDateForTime, (dataMap.get(TIME).longValue()));
        //System.out.println("adding " + dataMap.get("time").intValue() + " days to " + startDateFortime + " = " + cal.getTime());
        // get coordinates
        double latitude = dataMap.get(LAT).doubleValue();
        double longitude = flipPostiveLongitude(dataMap.get(LON));



        int areaId = GeoDao.getIdOfRegionContainingPoint(c, latitude, longitude, "boundary", "shape", "area_id");

        if (areaId != -1) {

            if (!doesStatisticRecordExist(areaId, thisDate, scenarioId, runNumber, entityType)) {
                insertInitialStatisticRecord(areaId, thisDate, scenarioId, runNumber, entityType);
            }
            updateStatisticRecord(areaId, thisDate, precip, scenarioId, runNumber, entityType);

            // handle max
            float currentMax = getMaxStatistic(areaId, thisDate, scenarioId, runNumber, entityType);

            if (currentMax < precip) {
                updateMaxStatistic(precip, areaId, thisDate, scenarioId, runNumber, entityType);
            }


            // handle min
            float currentMin = getMinStatistic(areaId, thisDate, scenarioId, runNumber, entityType);

            if (currentMin > precip) {
                updateMinStatistic(precip, areaId, thisDate, scenarioId, runNumber, entityType);
            }



        }
        // int pointId = GeoDao.storeGeometryChild(c, "precipitation", "location", 133, "country", sb.toString());
        // @todo insert the study value, date, and id into the data field

        DBUtils.close(c);
    }

    public void readNCFileIteratively(String filename) {
        NetcdfFile ncfile = null;
        try {
            ncfile = NetcdfFile.open(filename);
            ncfile.writeCDL(System.out, true);


            String fileInfo = ncfile.getDetailInfo();
            System.out.println(fileInfo);
            getStartDAte(ncfile);

            Variable v = ncfile.findVariable("pr");

            Variable time = ncfile.findVariable(TIME);
            Variable lat = ncfile.findVariable(LAT);
            Variable lon = ncfile.findVariable(LON);

            int[] origin = new int[]{3650, 89, 179};
            int[] size = new int[]{1, 1, 1};
            Array data3D = v.read(origin, size);

            Array timeVal = time.read(new int[]{3650}, new int[]{1});
            Array latVal = lat.read(new int[]{0}, new int[]{1});
            Array lonVal = lon.read(new int[]{179}, new int[]{1});
//            double[] ja = (double []) data3D.get1DJavaArray( double.class);

            int count = 0;
            while (data3D.hasNext()) {
                System.out.println(data3D.nextDouble());
                count++;
            }
            while (timeVal.hasNext()) {
                System.out.println(timeVal.next());
            }
            while (latVal.hasNext()) {
                System.out.println(latVal.next());
            }
            while (lonVal.hasNext()) {
                System.out.println(lonVal.next());
            }

            System.out.println(count + " is the size");
//            int count = 0;
//            while (data3D.hasNext()) {
//
//            }
            System.out.println("total are: " + count);

        } catch (ucar.ma2.InvalidRangeException ex) {
            Logger.getLogger(PrecipitationLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ioe) {
            //log("trying to open " + filename, ioe);
        } finally {
            if (null != ncfile) {
                try {
                    ncfile.close();
                } catch (IOException ioe) {
                    //log("trying to close " + filename, ioe);
                }
            }
        }

    }
}
