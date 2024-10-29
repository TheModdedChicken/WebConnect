<script lang="ts">
  import { portal } from '$lib/utility/svelte';
  import type { Snippet } from 'svelte';

  interface Props {
    children: Snippet<[]>
    class?: string
  }

  let { 
    children,
    class: external_class = ""
  }: Props = $props();
</script>

<div class={"px-5 py-3 bg-gray-100 rounded-lg text-sm " + external_class}>
  <p>{@render children()}</p>
</div>