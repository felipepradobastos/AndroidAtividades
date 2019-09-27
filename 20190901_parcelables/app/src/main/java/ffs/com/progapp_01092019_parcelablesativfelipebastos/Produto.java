package ffs.com.progapp_01092019_parcelablesativfelipebastos;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private String description;
    private double unitprice;
    private int quantity;

    public Produto(String description, double unitprice, int quantity) {
        this.description = description;
        this.unitprice = unitprice;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double valortotal(){
        return (double)this.unitprice*this.quantity;
    }

    protected Produto(Parcel in) {
        description = in.readString();
        unitprice = in.readDouble();
        quantity = in.readInt();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeDouble(unitprice);
        dest.writeInt(quantity);
    }
}
