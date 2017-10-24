
function reserveDate()
    {
        var Day = document.getElementById("datepicker").value;
        println(Day);
		selectTime.options.length=0;
        if (Day.value== "土"||Day.value == "日")
            {

                selectTime.options[0] = new Option(1+":00");

            }

        else
            {

                selectTime.options[i] = new Option(i+":00");
                }


    }