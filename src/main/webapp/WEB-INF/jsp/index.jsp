<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">

    <spring:url value="/css/main.css" var="springCss"/>
    <link href="${springCss}" rel="stylesheet"/>
    <c:url value="/css/main.css" var="jstlCss"/>
    <link href="${jstlCss}" rel="stylesheet"/>

</head>
<body>

<div class="container">

    <div class="starter-template">
        <h1 align="center">Welcome to Blind Santa</h1>
        <h2 align="center">Enter following data and send invites by clicking one button</h2>
    </div>

</div>

<div class="container">
    <form name="party" method="post" action="/createParty" novalidate>

        <div class="row">
            <label for="date">Enter your party date</label>
            <div class="row">
                <div class='col-sm-6'>
                    <div class="form-group">
                        <div class='input-group date' id='partyDate'>
                            <input type='text' class="form-control" id="date"
                           <%-- required="required" --%>
                            name="date"/>
                            <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                        </div>
                    </div>
                </div>
                <script type="text/javascript">
                    moment.updateLocale('en', {
                        week: {dow: 1} // Monday is the first day of the week
                    });
                    $(function () {
                        $('#partyDate').datetimepicker({
                            format: 'DD-MM-YYYY HH:mm'
                        });
                    });
                </script>
            </div>
        </div>

        <div class="row">
            <label for="location">Enter party place</label>
            <input type="text" class="form-control"
            <%--required="required" --%>
            id="location" name="location">
        </div>

        <div class="row">
            <label for="amount">Enter average amount</label>
            <input type="number" class="form-control" id="amount" name="amount">
        </div>

        <div class="container">
            <label for="participants">Add you friends</label>
            <table class="table table-hover" id="participants" name="participants">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>E-mail</th>
                    <th></th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>
                        <input type="text" class="participant-name form-control"
                        <%--required="required"--%>
                               id="participantName" name="participantName" minlength="1"/>
                    </td>
                    <td>
                        <input type="text" class="participant-name form-control" required="required"
                               id="participantEmail" name="participantEmail"
                         <%--      pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" --%>
                               />
                    </td>
                    <td>
                        <div>
                            <input type="button" class="btn btn-danger glyphicon glyphicon-remove" id="deleteParticipant" value="Remove"/>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="form-group">
            <input type="button" id="addParticipant" value="Add participant" class="btn btn-default">
            <script type="text/javascript">
                $("#addParticipant").click(function () {
                    $("#participants").each(function () {
                        var tds = '<tr>';
                        jQuery.each($('tr:last td', this), function () {
                            tds += '<td>' + $(this).html() + '</td>';
                        });
                        tds += '</tr>';
                        if ($('tbody', this).length > 0) {
                            $('tbody', this).append(tds);
                        } else {
                            $(this).append(tds);
                        }
                    });
                });
            </script>
        </div>

        <div class="form-group">
            <label for="message">Your message</label>
            <textarea class="form-control" rows="5" id="message" name="message"></textarea>
        </div>

        <input type="submit" value="Create your party!" class="btn btn-default">

    </form>
</div>

</body>

</html>