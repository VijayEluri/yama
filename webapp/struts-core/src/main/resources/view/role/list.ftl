<div class="row">
<form method="get" class="form-inline span12">
	<input type="text" name="q" value="${q!}" class="span6" placeholder="Search..." />
	<input type="submit" value="Search" class="span2 btn" />
	<a class="btn btn-primary pull-right" href="<@s.url value="${request.servletPath}/add"/>">New Role</a>
</form>
</div>

<#if success??>
<div class="alert fade in">
	<a class="close" data-dismiss="alert" href="#">&times;</a>
	Role successfully added!
</div>
</#if>
<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<th>#</th>
			<th>NAME</th>
			<th>DESCRIPTION</th>
			<!-- <th>TREE LEVEL</th> -->
			<th>ACTIONS</th>
		</tr>
	</thead>
	<tbody>
		<#assign no = (max * page) - max + 1>
		<#list roles.entityList as c>
		<tr>
			<td>${no}</td>
			<td>${c.name!}</td>
			<td>${c.description!}</td>
			<!-- <td><#assign level = 0 /><#list c.treePath?split(".") as l><#assign level = level + 1 /></#list>${level}</td> -->
			<td>
				<a class="btn" title="Edit" href="<@s.url value="${request.servletPath}/edit/${c.id!}"/>"><i class="icon-edit"></i></a>
				<!--  <a class="btn" title="Role Privilege" href="<@s.url value="/backend/role_privilege/edit/${c.id!}" />"><i class="icon-th-list"></i></a> -->
				<a class="btn confirm" title="Delete" href="<@s.url value="${request.servletPath}/delete/${c.id!}"/>" data-message="Are you sure want to delete ${c.name!}?"><i class="icon-trash"></i></a>
			</td>
		</tr>
		<#assign no = no + 1>
		</#list>
	</tbody>
</table>
<span class="label pull-left">Found ${roles.rowCount} row(s)</span>
<div class="btn-group pull-right">
	<#if page &gt; 1>
	<a class="btn" href="${request.servletPath}?max=${max}&page=1"><i class="icon-fast-backward"></i>&nbsp;</a>
	<a class="btn" href="${request.servletPath}?max=${max}&page=${page - 1}"><i class="icon-backward"></i>&nbsp;</a>
	</#if>
	<a class="btn disabled">${page} of ${roles.totalPage}</a>
	<#if page &lt; roles.totalPage>
	<a class="btn" href="${request.servletPath}?max=${max}&page=${page + 1}">&nbsp;<i class="icon-forward"></i></a>
	<a class="btn" href="${request.servletPath}?max=${max}&page=${roles.totalPage}">&nbsp;<i class="icon-fast-forward"></i></a>
	</#if>
</div>