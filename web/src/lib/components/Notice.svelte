<script lang="ts">
  import type { Snippet } from 'svelte';

  interface Props {
    children: Snippet<[]>
    class?: string
    
    type?: "info" | "warn" | "danger"
  }

  let { 
    children,
    class: external_class = "",

    type = "info"
  }: Props = $props();
</script>

<div class={`flex flex-row items-center space-x-3 px-4 py-3 rounded-lg text-sm ${type} prose-p:w-full prose-p:h-fit ` + external_class}>
  {@render children()}
</div>