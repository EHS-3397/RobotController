package org.firstinspires.ftc.teamcode

import com.qualcomm.hardware.bosch.BNO055IMU
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator
import com.qualcomm.robotcore.hardware.*
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName

class Hardware(hwMap: HardwareMap) {
    var motorBL: DcMotor? = null
    var motorBR: DcMotor? = null
    var motorFL: DcMotor? = null
    var motorFR: DcMotor? = null
    var motorDucks: DcMotor? = null
    var motorArm: DcMotor? = null
    var servoArm: Servo? = null
    var webcamName: WebcamName? = null
    var cameraMonitorViewId : Int? = null
    var controlHubIMU: BNO055IMU? = null
    var expansionHubIMU: BNO055IMU? = null
    var distanceSensorFront: DistanceSensor? = null
    var distanceSensorLeft: ColorRangeSensor? = null
    var distanceSensorRight: ColorRangeSensor? = null
    var distanceSensorBack: ColorRangeSensor? = null

    init {
        motorBL = hwMap.get(DcMotor::class.java, "motor0")
        motorBR = hwMap.get(DcMotor::class.java, "motor1")
        motorBR?.direction = DcMotorSimple.Direction.REVERSE
        motorFR = hwMap.get(DcMotor::class.java, "motor2")
        motorFR?.direction = DcMotorSimple.Direction.REVERSE
        motorFL = hwMap.get(DcMotor::class.java, "motor3")
        motorDucks = hwMap.get(DcMotor::class.java, "motor4")
        motorArm = hwMap.get(DcMotor::class.java, "motor5")
        motorArm?.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        servoArm = hwMap.get(Servo::class.java, "servo0")
        webcamName = hwMap.get(WebcamName::class.java, "camera0")
        distanceSensorFront = hwMap.get(DistanceSensor::class.java, "distance0")
        distanceSensorLeft = hwMap.get(ColorRangeSensor::class.java, "color0")
        distanceSensorRight = hwMap.get(ColorRangeSensor::class.java, "color1")
        distanceSensorBack = hwMap.get(ColorRangeSensor::class.java, "color2")
        cameraMonitorViewId = hwMap.appContext.resources.getIdentifier("cameraMonitorViewId", "id", hwMap.appContext.packageName)
        controlHubIMU = hwMap.get(BNO055IMU::class.java, "imu1")
        expansionHubIMU = hwMap.get(BNO055IMU::class.java, "imu0")

        val parameters = BNO055IMU.Parameters()
        parameters.mode                = BNO055IMU.SensorMode.IMU
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC
        parameters.accelerationIntegrationAlgorithm = JustLoggingAccelerationIntegrator()
        parameters.loggingEnabled      = false
        controlHubIMU?.initialize(parameters)
        expansionHubIMU?.initialize(parameters)
    }
}
