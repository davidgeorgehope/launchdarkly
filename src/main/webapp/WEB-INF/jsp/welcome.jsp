<html>
<head>
	<title>Welcome</title>

	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="css/custom.css"
		rel="stylesheet">
    <script crossorigin="anonymous" src="https://unpkg.com/launchdarkly-js-client-sdk@2.22.1"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="js/custom.js"></script>
</head>
<body>
<script>
    function main()
    {

        $.get({
        url: "hello",
        contentType: "text/plain",
        type: 'GET',
        success: function (response) {
                          var edit = document.getElementById('back-end-flag');
                       edit.replaceChild(document.createTextNode(response), edit.firstChild);
              }})

            // Set clientSideID to your LaunchDarkly client-side ID
                  const clientSideID = '${clientId}';

                  // Set flagKey to the feature flag key you want to evaluate
                  const flagKey = 'edit-note';

                  // Set up the user properties. This user should appear on your
                  // LaunchDarkly users dashboard soon after you run the demo.
                  const user = {
                    'key': '${userId}',
                    'name': '${userId}'
                  };

                  const ldclient = LDClient.initialize(clientSideID, user);

                  function render() {
                    const flagValue = ldclient.variation(flagKey, false);
                    if(flagValue){
                          var edit = document.getElementById('edit');

                       edit.replaceChild(document.createTextNode(""), edit.firstChild);
                    }
                  }

                  ldclient.on('ready', render);
                  ldclient.on('change', render);
                  ldclient.close();


    }
    main();
    </script>
	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>Todo 1</td>
						<td>10/12/2017</td>
						<td>No</td>

						<td id='edit'><a class="btn btn-warning" href="/edit-todo">Edit Todo</a></td>
						<td id='delete'><a class="btn btn-warning" href="/delete-todo">Delete Todo</a></td>
					</tr>
			</tbody>
		</table>

		<div id='back-end-flag'>
            <div>

            </div>
		</div>

	</div>
</body>
</html>
