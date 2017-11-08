' Author:       Justin Clark
' Course:       COP 2010
' Project #:    2
' Title:        Unit Converter
' Due Date:     2/8/2013

' Converts U.S. units of measurement to Metric and English equivalents

''' <summary>
''' Converts U.S. units of measurement to Metric and English equivalents
''' </summary>
''' <remarks></remarks>
Public Class FormMain
    ' Variable declaratons
    Dim degreesC, kelvins, meters, inches, kilos, stone As Double

    Private Sub ConvertButton_Click(sender As Object, e As EventArgs) Handles ConvertButton.Click
        ' Variable declaratons
        Dim degreesF, feet, pounds As Integer

        ' Get user input
        degreesF = FahrenheitUpDown.Value
        feet = FeetUpDown.Value
        pounds = PoundsUpDown.Value

        ' Perform conversions
        PerformConversions(degreesF, feet, pounds)

        ' Output converted values to form
        CelsiusTextBox.Text = String.Format("{0:N}", degreesC)
        KelvinTextBox.Text = String.Format("{0:N}", kelvins)
        MetersTextBox.Text = String.Format("{0:N}", meters)
        InchesTextBox.Text = String.Format("{0:N}", inches)
        KilogramsTextBox.Text = String.Format("{0:N}", kilos)
        StoneTextBox.Text = String.Format("{0:N}", stone)
    End Sub

    Private Sub ConvertDistance(ByVal feet As Integer)
        meters = feet * 0.3048
        inches = feet * 12
    End Sub

    Private Sub ConvertTemperature(ByVal fahrenheit As Integer)
        degreesC = (fahrenheit - 32) * 5 / 9
        kelvins = (fahrenheit + 459.67) * 5 / 9
    End Sub

    Private Sub ConvertWeight(ByVal pounds As Integer)
        kilos = pounds * 0.4536
        stone = pounds * 0.0714285714
    End Sub

    Private Sub PerformConversions(ByVal fahrenheit As Integer, ByVal feet As Integer, ByVal pounds As Integer)
        ConvertDistance(feet)
        ConvertTemperature(fahrenheit)
        ConvertWeight(pounds)
    End Sub
End Class
