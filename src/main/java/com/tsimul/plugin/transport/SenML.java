package com.tsimul.plugin.transport;

import com.tsimul.measure.SensorMeasure;

/**
 *      see https://tools.ietf.org/pdf/rfc8428.pdf
 *      +---------------+-------+------------+------------+------------+
 *      |          Name | Label | CBOR Label | JSON Type  | XML Type   |
 *      +---------------+-------+------------+------------+------------+
 *      |     Base Name | bn    |         -2 | String     | string     |
 *      |     Base Time | bt    |         -3 | Number     | double     |
 *      |     Base Unit | bu    |         -4 | String     | string     |
 *      |    Base Value | bv    |         -5 | Number     | double     |
 *      |      Base Sum | bs    |         -6 | Number     | double     |
 *      |  Base Version | bver  |         -1 | Number     | int        |
 *      |          Name | n     |          0 | String     | string     |
 *      |          Unit | u     |          1 | String     | string     |
 *      |         Value | v     |          2 | Number     | double     |
 *      |  String Value | vs    |          3 | String     | string     |
 *      | Boolean Value | vb    |          4 | Boolean    | boolean    |
 *      |    Data Value | vd    |          8 | String (*) | string (*) |
 *      |           Sum | s     |          5 | Number     | double     |
 *      |          Time | t     |          6 | Number     | double     |
 *      |   Update Time | ut    |          7 | Number     | double     |
 *      +---------------+-------+------------+------------+------------+
 */

public class SenML {

    /**
     * Base fields
     */

    private String bn; // Base Name
    private double bt; // Base Time
    private String bu; // Base Unit
    private double bv; // Base Value
    private double bs; // Base Sum
    private int bver; // Base Version

    /**
     * Regular fields
     */

    private String n; // Name
    private String u; // Unit
    private double v; // Current Value
    private String vs; // String Value
    private Boolean vb; // Boolean Value
    private String vd; // Data value String (*) in Java can be represented as byte[] vd
    private double sum; // Sum
    private double t; // Time (Relative or Absolute)
    private double ut; // Update Time (Sec.)

    /**
     * Default values
     */

    public static final int BASE_VERSION = 10;

    /**
     * Setters and Getters
     */

    public String getBn() {
        return bn;
    }

    public void setBn(String bn) {
        this.bn = bn;
    }

    public double getBt() {
        return bt;
    }

    public void setBt(double bt) {
        this.bt = bt;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public double getBv() {
        return bv;
    }

    public void setBv(double bv) {
        this.bv = bv;
    }

    public double getBs() {
        return bs;
    }

    public void setBs(double bs) {
        this.bs = bs;
    }

    public int getBver() {
        return bver;
    }

    public void setBver(int bver) {
        this.bver = bver;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public String getVs() {
        return vs;
    }

    public void setVs(String vs) {
        this.vs = vs;
    }

    public Boolean getVb() {
        return vb;
    }

    public void setVb(Boolean vb) {
        this.vb = vb;
    }

    public String getVd() {
        return vd;
    }

    public void setVd(String vd) {
        this.vd = vd;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double getUt() {
        return ut;
    }

    public void setUt(double ut) {
        this.ut = ut;
    }

    /**
     * Helpers
     */

    public static SenML toSenML(SensorMeasure data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "SenML: {" +
                "bn='" + bn + '\'' +
                ", bt=" + bt +
                ", bu='" + bu + '\'' +
                ", bv=" + bv +
                ", bs=" + bs +
                ", bver=" + bver +
                ", n='" + n + '\'' +
                ", u='" + u + '\'' +
                ", v=" + v +
                ", vs='" + vs + '\'' +
                ", vb=" + vb +
                ", vd='" + vd + '\'' +
                ", sum=" + sum +
                ", t=" + t +
                ", ut=" + ut +
                '}';
    }

    /**
     * Return a json representation of this measure as a json object
     * For efficiency this representation should exclude any null field from the final result
     * @return a string (json) representation of the record containing only non-null values.
     * TODO
     */
    public String asJsonRecord() {
        throw new UnsupportedOperationException("Not yet implemented");
        /*
        return "" +
                bn == null ? "" : "bn:" + bn;*/
    }
}
