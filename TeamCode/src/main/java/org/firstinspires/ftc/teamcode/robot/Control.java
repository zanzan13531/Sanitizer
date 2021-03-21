package org.firstinspires.ftc.teamcode.robot;


public class Control {

    final float maxAngVel = 1.0f;
    final float turnCircle = (float) (2 * Math.PI * Math.sqrt(Math.pow(7.9, 2) + Math.pow(6.65, 2)));

    private float kP = 10.0f;
    private float kD = 0.0f;
    private float kI = 0.0f;

    private float[] error = {0.0f, 0.0f, 0.0f};
    private float[] errorPast = {0.0f, 0.0f, 0.0f};
    private float[] errorDiff = {0.0f, 0.0f, 0.0f};
    private float[] errorSum = {0.0f, 0.0f, 0.0f};

    // Normalization coefficients
    private float kX = 1 / maxAngVel;
    private float kY = 1 / maxAngVel;
    private float kW = 1 / turnCircle;

    public Control() {
    }

    public float[] getWheelPower(float angle) {
        float[] wheelPower = new float[4];

        // Translates global error values in terms of car's local coordinate system
        float[] errorLoc = rotate(error[0], error[1], -angle);
        float[] errorDiffLoc = rotate(errorDiff[0], errorDiff[1], -angle);
        float[] errorSumLoc = rotate(errorSum[0], errorSum[1], -angle);

        wheelPower[0] = -(kP * (kX * errorLoc[0] - kY * errorLoc[1] + kW * error[2])
                + kD * (kX * errorDiffLoc[0] - kY * errorDiffLoc[1] + kW * errorDiff[2])
                + kI * (kX * errorSumLoc[0] - kY * errorSumLoc[1] + kW * errorSum[2]));

        wheelPower[1] = -(kP * (kX * errorLoc[0] - kY * errorLoc[1] - kW * error[2])
                + kD * (kX * errorDiffLoc[0] - kY * errorDiffLoc[1] - kW * errorDiff[2])
                + kI * (kX * errorSumLoc[0] - kY * errorSumLoc[1] - kW * errorSum[2]));

        wheelPower[2] = -(kP * (kX * errorLoc[0] + kY * errorLoc[1] - kW * error[2])
                + kD * (kX * errorDiffLoc[0] + kY * errorDiffLoc[1] - kW * errorDiff[2])
                + kI * (kX * errorSumLoc[0] + kY * errorSumLoc[1] - kW * errorSum[2]));

        wheelPower[3] = -(kP * (kX * errorLoc[0] + kY * errorLoc[1] + kW * error[2])
                + kD * (kX * errorDiffLoc[0] + kY * errorDiffLoc[1] + kW * errorDiff[2])
                + kI * (kX * errorSumLoc[0] + kY * errorSumLoc[1] + kW * errorSum[2]));

        float max = 1.0f;  // Wheel power can't go over 1
        for (int i = 0; i < 4; i += 1) {
            if (max < wheelPower[i]) {
                max = wheelPower[i];
            }
        }
        for (int i = 0; i < 4; i += 1) {
            wheelPower[i] /= max;
        }

        return wheelPower;
    }

    public void logErrors(float[] target, float[] actual, float dt) {
        errorPast = error.clone();

        error[0] = actual[0] - target[0];
        error[1] = actual[1] - target[1];
        error[2] = ((actual[2] - target[2] + (float) Math.PI) % (float) (2 * Math.PI)) - (float) Math.PI;

        errorDiff[0] = (error[0] - errorPast[0]) / dt;
        errorDiff[1] = (error[1] - errorPast[1]) / dt;
        errorDiff[2] = (error[2] - errorPast[2]) / dt;

        errorSum[0] += error[0] * dt;
        errorSum[1] += error[1] * dt;
        errorSum[2] += error[2] * dt;

    }

    public void resetErrors() {
        // Technically none of the errors need be reset except...
        errorSum[0] = 0.0f;
        errorSum[1] = 0.0f;
        errorSum[2] = 0.0f;
    }

    public float bezier(float t, float tMax, float[] x) {
        float[] midpoints = x.clone();  // Not actually THE midpoint
        for (int i = 1; i < x.length; i += 1) {
            for (int j = 0; j < x.length - i; j += 1) {
                midpoints[j] = t / tMax * midpoints[j + 1] + (1 - t / tMax) * midpoints[j];
            }
        }
        return midpoints[0];
    }

    public float getErrorX() {
        return error[0];
    }

    public float getErrorY() {
        return error[1];
    }

    public float getErrorW() {
        return error[2];
    }

    public float[] rotate(float x, float y, float angle) {
        float c = (float) Math.cos(angle);
        float s = (float) Math.sin(angle);
        float xNew = c * x - s * y;
        float yNew = c * y + s * x;
        return new float[] {xNew, yNew};
    }
}