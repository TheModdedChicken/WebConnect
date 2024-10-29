<script lang="ts">
	import '../app.css';

	let { children } = $props();
</script>

<div class="absolute flex justify-center items-center w-full h-full bg-slate-600 bg-opacity-40 invisible has-[*.modal]:visible">
	<div id="portal" class="mx-5 min-w-[300px] w-full max-w-[400px] space-y-8">

	</div>
</div>

<header class="px-[15px] py-[10px]">
	<h5>{"{{BRANDING:TITLE}}"}</h5>
</header>

<main class="flex justify-center mx-5 my-4">
	<div class="min-w-[300px] w-full max-w-[400px] space-y-8">
		{@render children()}
	</div>
</main>