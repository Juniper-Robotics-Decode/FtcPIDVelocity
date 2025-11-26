package org.firstinspires.ftc.teamcode;

public class TransferFSM {


    enum State {
        MOVING_DOWN,
        MOVING_UP,
        START_TO_MOVE,
        STOPPING
    }

    private State currentState = State.STOPPING;


    public void runOpMode() {


        // Change to Hardware Wrappers //
        switch (currentState) {

            case MOVING_UP:


                break;

            case MOVING_DOWN:

                break;

            case START_TO_MOVE:

                break;


        }

    }
}
